/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Booking_Controller;
import java.sql.ResultSet;

/**
 *
 * @author sev_user
 */
public class BookingDetailBLL {

    Booking_Controller bookingCtrl = new Booking_Controller();

    public ResultSet getAllBookingDetail() {
        return bookingCtrl.getAllBookingDetail();
    }

    public ResultSet getBookingDetailByID(int bookingID) {
        return bookingCtrl.getBookingDetailByID(bookingID);
    }

    public int addNewBookingDetail(BookingDetail bookingDetail) {
        return bookingCtrl.addNewBookingDetail(bookingDetail);
    }

    public int updateBookingDetail(BookingDetail bookingDetail) {
        return bookingCtrl.updateBookingDetail(bookingDetail);
    }

    public int deleteBookingDetailByID(int ID) {
        return bookingCtrl.deleteBookingDetailByID(ID);
    }

    public int getBookingDetail(int bookingID, int roomID) {
        return bookingCtrl.getBookingDetail(bookingID, roomID);
    }

    public int deleteBookingDetail(int bookingID, int roomID) {
        return bookingCtrl.deleteBookingDetail(bookingID, roomID);
    }
}
