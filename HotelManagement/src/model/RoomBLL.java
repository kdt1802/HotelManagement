/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Room_Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sev_user
 */
public class RoomBLL {

    Room_Controller mRoomCtl = new Room_Controller();
    ResultSet mRs = null;
    private static Room mRoom;

    public ResultSet getAllRoom() {
        return mRoomCtl.getAllRoom();
    }

    public Room getRoomByID(int ID) {
        return mRoomCtl.getRoomByID(ID);
    }

    public int addRoom(Room room) {
        return mRoomCtl.addRoom(room);
    }

    public int updateRoom(Room room) {
        return mRoomCtl.updateRoom(room);
    }

    public ResultSet getRoomByType(int roomType) {
        return mRoomCtl.getRoomByType(roomType);
    }

    public int deleteRoom(int roomID) {
        return mRoomCtl.deleteRoom(roomID);
    }

    public ResultSet searchFreeRoom(int type, String checkinTime, String checkoutTime) {
        return mRoomCtl.searchFreeRoom(type, checkinTime, checkoutTime);
    }

    public boolean isExtendable(int bookingID, int roomID, String checkinTime, String checkoutTime) {
        return mRoomCtl.isExtendable(bookingID, roomID, checkinTime, checkoutTime);
    }

    public int isRoomUsing(int roomID) {
        return mRoomCtl.isRoomUsing(roomID);
    }

    public int canDeleteRoom(int roomID) {
        return mRoomCtl.canDeleteRoom(roomID);
    }

    public Room getRoomByRoomNumber(int roomNumber) {
        return mRoomCtl.getRoomByRoomNumber(roomNumber);
    }
}
