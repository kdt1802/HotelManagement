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
public class BookingBLL {

    Booking_Controller bookingCtrl = new Booking_Controller();

    public int getLatestBookingID() {
        return bookingCtrl.getLatestbookingID();
    }

    public int addNewBooking(Booking booking) {
        return bookingCtrl.addNewBooking(booking);
    }

    public int updateBooking(Booking booking) {
        return bookingCtrl.updateBooking(booking);
    }

    public ResultSet getAllBooking() {
        return bookingCtrl.getAllBooking();
    }

    public int deleteBookingByID(int ID) {
        return bookingCtrl.deleteBookingByID(ID);
    }

    public int checkIn(int bookingID, int status) {
        return bookingCtrl.checkIn(bookingID, status);
    }

    public ResultSet getBookingByID(int bookingID) {
        return bookingCtrl.getBookingByID(bookingID);
    }

    public int freeRoom(int bookingID, int status) {
        return bookingCtrl.freeRoom(bookingID, status);
    }
    
    public int cancelBooking(int bookingID) {
        return bookingCtrl.cancelBooking(bookingID);
    }

    public int reBooking(int bookingID) {
        return bookingCtrl.reBooking(bookingID);
    }
}
