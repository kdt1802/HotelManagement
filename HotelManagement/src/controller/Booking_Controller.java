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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.Booking;
import model.BookingDetail;
import model.BookingDetail1;

/**
 *
 * @author sev_user
 */
public class Booking_Controller {

    Connection mCon;

    public ResultSet getAllBooking() {
        String sql = "select * from BOOKING";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeQuery();

        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet getBookingByID(int bookingID) {
        String sql = "select * from BOOKING where bookingID = " + bookingID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeQuery();
        } catch (SQLException ex) {
            return null;
        }
    }

    public int getLatestbookingID() {
        int ID = 0;
        String sql = "select MAX(bookingID) from BOOKING";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                ID = rs.getInt(1);
            }
            System.out.println(ID);
        } catch (SQLException ex) {
            return 0;
        }
        return ID;
    }

    public int addNewBooking(Booking booking) {
        String sql = "insert into BOOKING values(?,?,?,?,?)";
        DateFormat mDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        String bookingTime = mDateFormat.format(booking.getBookingTime());
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);

            prStm.setString(1, "" + booking.getClientID());
            prStm.setString(2, booking.getNote());
            prStm.setString(3, bookingTime);
            prStm.setString(4, "" + booking.getEstimatePrice());
            prStm.setString(5, "" + booking.getStatus());

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int updateBooking(Booking booking) {
        String sql = "Update BOOKING set note = ?, estimatePrice = ? Where bookingID = ?";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            prStm.setString(1, booking.getNote());
            prStm.setString(2, "" + booking.getEstimatePrice());
            prStm.setString(3, "" + booking.getBookingID());

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int deleteBookingByID(int ID) {
        String sql = "DELETE from BOOKING where bookingID = " + ID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int checkIn(int bookingID, int status) {
        String sql = "Update BOOKING set status = " + status + " where bookingID = " + bookingID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int cancelBooking(int bookingID) {
        // Set booking status = 3 (canceled)
        String sql = "Update BOOKING set status = 3 where bookingID = " + bookingID;

        // Set room status in booking to canceled 
        String sql1 = "Update BOOKING_DETAIL set status = 3 where bookingID = " + bookingID;

        // set service status in booking to 0 (Not be used in this booking anymore)
        String sql2 = "Update BOOKING_DETAIL_1 set status = 0 where bookingID = " + bookingID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            PreparedStatement prStm1 = mCon.prepareStatement(sql1);
            PreparedStatement prStm2 = mCon.prepareStatement(sql2);

            prStm.executeUpdate();
            prStm1.executeUpdate();
            prStm2.executeUpdate();

            return 1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int reBooking(int bookingID) {
        // Set booking status = 0 (Booked)
        String sql = "Update BOOKING set status = 0 where bookingID = " + bookingID;

        // Set room status in booking to booked 
        String sql1 = "Update BOOKING_DETAIL set status = 0 where bookingID = " + bookingID;

        // set service status in booking to 1 (Being used in this booking)
        String sql2 = "Update BOOKING_DETAIL_1 set status = 1 where bookingID = " + bookingID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            PreparedStatement prStm1 = mCon.prepareStatement(sql1);
            PreparedStatement prStm2 = mCon.prepareStatement(sql2);

            prStm.executeUpdate();
            prStm1.executeUpdate();
            prStm2.executeUpdate();

            return 1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    //BOOKING_DETAIL controller
    public ResultSet getAllBookingDetail() {
        String sql = "select * from BOOKING_DETAIL";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeQuery();

        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet getBookingDetailByID(int bookingID) {
        String sql = "select * from BOOKING_DETAIL where bookingID = " + bookingID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeQuery();
        } catch (SQLException ex) {
            return null;
        }
    }

    public int addNewBookingDetail(BookingDetail bookingDetail) {
        String sql = "insert into BOOKING_DETAIL values(?,?,?,?,?,?)";
        DateFormat mDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String checkinTime = mDateFormat.format(bookingDetail.getCheckinTime());
        String checkoutTime = mDateFormat.format(bookingDetail.getCheckoutTime());

        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);

            prStm.setString(1, "" + bookingDetail.getBookingID());
            prStm.setString(2, "" + bookingDetail.getRoomID());
            prStm.setString(3, "" + bookingDetail.getRoomPrice());
            prStm.setString(4, checkinTime);
            prStm.setString(5, checkoutTime);
            prStm.setString(6, "" + bookingDetail.getStatus());

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int updateBookingDetail(BookingDetail bookingDetail) {
        String sql = "Update BOOKING_DETAIL set roomPrice = ?, checkinTime = ?, checkoutTime = ?, status= ? Where bookingID = ? AND roomID = ?";
        System.out.println("bookingID: " + bookingDetail.getBookingID());
        System.out.println("roomID: " + bookingDetail.getRoomID());
        System.out.println("checkin: " + bookingDetail.getCheckinTime());
        System.out.println("checkout: " + bookingDetail.getCheckoutTime());
        System.out.println("status: " + bookingDetail.getStatus());

        DateFormat mDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String checkinTime = mDateFormat.format(bookingDetail.getCheckinTime());
        String checkoutTime = mDateFormat.format(bookingDetail.getCheckoutTime());
        System.out.println(checkinTime);
        System.out.println(checkoutTime);
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            prStm.setString(1, "" + bookingDetail.getRoomPrice());
            prStm.setString(2, checkinTime);
            prStm.setString(3, checkoutTime);
            prStm.setString(4, "" + bookingDetail.getStatus());
            prStm.setString(5, "" + bookingDetail.getBookingID());
            prStm.setString(6, "" + bookingDetail.getRoomID());

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int deleteBookingDetailByID(int ID) {
        String sql = "DELETE from BOOKING_DETAIL where bookingID = " + ID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int deleteBookingDetail(int bookingID, int roomID) {
        String sql = "DELETE from BOOKING_DETAIL where bookingID = " + bookingID + " AND roomID = " + roomID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int getBookingDetail(int bookingID, int roomID) {
        String sql = "select * from BOOKING_DETAIL where bookingID = " + bookingID + " AND roomID = " + roomID;
        int result = 0;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                result = 1;
            }
            return result;
        } catch (SQLException ex) {
            return result;
        }
    }

    public int freeRoom(int bookingID, int status) {
        String sql = "Update BOOKING_DETAIL set status = " + status + " where bookingID = " + bookingID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    //BOOKING_DETAIL_1 Controller
    public ResultSet getAllBookingDetail_1() {
        String sql = "select * from BOOKING_DETAIL_1";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeQuery();

        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet getBookingDetail_1_ByID(int bookingID) {
        String sql = "select * from BOOKING_DETAIL_1 where bookingID = " + bookingID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeQuery();
        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet getBookingDetail_1_By_ServiceID(int serviceID) {
        String sql = "select * from BOOKING_DETAIL_1 where serviceID = " + serviceID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeQuery();
        } catch (SQLException ex) {
            return null;
        }
    }

    public int addNewBookingDetail_1(BookingDetail1 bookingDetail1) {
        String sql = "insert into BOOKING_DETAIL_1 values(?,?,?,?,?,?)";

        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);

            prStm.setString(1, "" + bookingDetail1.getBookingID());
            prStm.setString(2, "" + bookingDetail1.getServiceID());
            prStm.setString(3, bookingDetail1.getServiceName());
            prStm.setString(4, "" + bookingDetail1.getServiceQuantity());
            prStm.setString(5, "" + bookingDetail1.getServicePrice());
            prStm.setString(6, "" + bookingDetail1.getStatus());

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int updateBookingDetail_1(BookingDetail1 bookingDetail1) {
        String sql = "Update BOOKING_DETAIL_1 set serviceName = ?, serviceQuantity = ?, servicePrice = ?, status = ? Where bookingID = ? AND serviceID = ?";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            prStm.setString(1, "" + bookingDetail1.getServiceName());
            prStm.setString(2, "" + bookingDetail1.getServiceQuantity());
            prStm.setString(3, "" + bookingDetail1.getServicePrice());
            prStm.setString(4, "" + bookingDetail1.getStatus());
            prStm.setString(5, "" + bookingDetail1.getBookingID());
            prStm.setString(6, "" + bookingDetail1.getServiceID());

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int deleteBookingDetail_1_ByID(int ID) {
        String sql = "DELETE from BOOKING_DETAIL_1 where bookingID = " + ID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int deleteBookingDetail_1(int bookingID, int serviceID) {
        String sql = "DELETE from BOOKING_DETAIL_1 where bookingID = " + bookingID + " AND serviceID = " + serviceID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int getBookingDetail_1(int bookingID, int serviceID) {
        String sql = "select * from BOOKING_DETAIL_1 where bookingID = " + bookingID + " AND serviceID = " + serviceID;
        int result = 0;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                result = 1;
            }
            return result;
        } catch (SQLException ex) {
            return result;
        }
    }

    public int isServiceUsing(int serviceID) {
        String sql = "select * from BOOKING_DETAIL_1 where serviceID = " + serviceID + " AND status = 1";
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

    public int canDeleteService(int serviceID) {
        String sql = "select * from BOOKING_DETAIL_1 where serviceID = " + serviceID;
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
}
