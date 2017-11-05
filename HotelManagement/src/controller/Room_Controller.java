/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Room;

/**
 *
 * @author sev_user
 */
public class Room_Controller {

    private static Connection mCon;

    public ResultSet getAllRoom() {
        String sql = "select * from ROOM";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeQuery();

        } catch (SQLException ex) {
            return null;
        }
    }

    public Room getRoomByID(int roomID) {
        Room mRoom = new Room();
        String sql = "select * from ROOM where roomID = " + roomID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                mRoom.setRoomID(rs.getInt(1));
                mRoom.setRoomType(rs.getInt(2));
                mRoom.setRoomNumber(rs.getInt(3));
                mRoom.setNightPrice(rs.getFloat(4));
                mRoom.setHourPrice(rs.getFloat(5));
                mRoom.setStatus(rs.getInt(6));
            }
            return mRoom;
        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet getRoomByType(int roomType) {
        String sql = "select * from ROOM where type = " + roomType;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);

            return prStm.executeQuery();
        } catch (SQLException ex) {
            return null;
        }
    }

    public int addRoom(Room room) {
        String sql = "INSERT INTO ROOM(type, roomNumber, nightPrice, hourPrice, status) VALUES(?,?,?,?,?)";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            prStm.setString(1, "" + room.getRoomType());
            prStm.setString(2, "" + room.getRoomNumber());
            prStm.setString(3, "" + room.getNightPrice());
            prStm.setString(4, "" + room.getHourPrice());
            prStm.setString(5, "" + room.getStatus());

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int updateRoom(Room room) {
        String sql = "UPDATE ROOM SET type = ?, roomNumber = ?, nightPrice = ?, hourPrice = ?, status = ? where roomID = " + room.getRoomID();

        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            prStm.setString(1, "" + room.getRoomType());
            prStm.setString(2, "" + room.getRoomNumber());
            prStm.setString(3, "" + room.getNightPrice());
            prStm.setString(4, "" + room.getHourPrice());
            prStm.setString(5, "" + room.getStatus());

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int deleteRoom(int roomID) {
        String sql = "DELETE FROM ROOM WHERE roomID = " + roomID;

        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public ResultSet searchFreeRoom(int type, String checkinTime, String checkoutTime) {
        String sql = "select * from ROOM left join BOOKING_DETAIL on ROOM.roomID = BOOKING_DETAIL.roomID "
             + "where ROOM.status = 0 AND ROOM.type = " + type + " AND (BOOKING_DETAIL.checkinTime IS NULL OR BOOKING_DETAIL.status > 1 "
             + "OR (BOOKING_DETAIL.checkinTime > '" + checkoutTime + "' OR BOOKING_DETAIL.checkoutTime < '" + checkinTime + "'))";

        System.out.println(sql);
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);

            return prStm.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean isExtendable(int bookingID, int roomID, String checkinTime, String checkoutTime) {
        String sql = "select * from BOOKING_DETAIL where roomID = " + roomID
             + " AND bookingID != " + bookingID + " AND status < 2"
             + " AND ((checkinTime <= '" + checkoutTime + "' OR checkoutTime >= '" + checkinTime + "'))";

        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);

            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public int isRoomUsing(int roomID) {
        String sql = "select * from BOOKING_DETAIL join BOOKING"
             + " on BOOKING_DETAIL.bookingID = BOOKING.bookingID where roomID = " + roomID + " and BOOKING.status < 2";
        int result = 0;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                result = 1;
                break;
            }
            return result;
        } catch (SQLException ex) {
            return result;
        }
    }

    public int canDeleteRoom(int roomID) {
        String sql = "select * from BOOKING_DETAIL where roomID = " + roomID;
        int result = 0;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                result = 1;
                break;
            }
            return result;
        } catch (SQLException ex) {
            return result;
        }
    }

    public Room getRoomByRoomNumber(int roomNumber) {
        Room mRoom = new Room();
        String sql = "select * from ROOM where roomNumber = " + roomNumber;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                mRoom.setRoomID(rs.getInt(1));
                mRoom.setRoomType(rs.getInt(2));
                mRoom.setRoomNumber(rs.getInt(3));
                mRoom.setNightPrice(rs.getFloat(4));
                mRoom.setHourPrice(rs.getFloat(5));
                mRoom.setStatus(rs.getInt(6));
            }
            return mRoom;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static boolean availableToReBooking(int bookingID, int roomID, String checkinTime, String checkoutTime) {
        String sql = "select * from BOOKING_DETAIL where roomID = " + roomID + " AND bookingID != " + bookingID + " AND status < 2"
             + " AND ((checkinTime <= '" + checkinTime + "' AND checkoutTime >= '" + checkoutTime + "')"
             + " OR (checkinTime >= '" + checkinTime + "' AND checkoutTime <= '" + checkoutTime + "')"
             + " OR (checkinTime >= '" + checkinTime + "' AND checkinTime <= '" + checkoutTime + "' AND checkoutTime >= '" + checkoutTime + "') "
             + " OR (checkoutTime >= '" + checkinTime + "' AND checkoutTime <= '" + checkoutTime + "' AND checkinTime <= '" + checkinTime + "'))";

        System.out.println(sql);
        System.out.println(checkinTime);
        System.out.println(checkoutTime);
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);

            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
