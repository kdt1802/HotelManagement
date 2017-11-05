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
public class BookingDetail1BLL {

    Booking_Controller bookingCtrl = new Booking_Controller();

    public ResultSet getAllBookingDetail_1() {
        return bookingCtrl.getAllBookingDetail_1();
    }

    public ResultSet getBookingDetail_1_ByID(int bookingID) {
        return bookingCtrl.getBookingDetail_1_ByID(bookingID);
    }

    public int addNewBookingDetail_1(BookingDetail1 bookingDetail1) {
        return bookingCtrl.addNewBookingDetail_1(bookingDetail1);
    }

    public int updateBookingDetail_1(BookingDetail1 bookingDetail1) {
        return bookingCtrl.updateBookingDetail_1(bookingDetail1);
    }

    public int deleteBookingDetail_1_ByID(int ID) {
        return bookingCtrl.deleteBookingDetail_1_ByID(ID);
    }

    public int deleteBookingDetail_1(int bookingID, int serviceID) {
        return bookingCtrl.deleteBookingDetail_1(bookingID, serviceID);
    }

    public int getBookingDetail_1(int bookingID, int serviceID) {
        return bookingCtrl.getBookingDetail_1(bookingID, serviceID);
    }

    public int isServiceUsing(int serviceID) {
        return bookingCtrl.isServiceUsing(serviceID);
    }

    public int canDeleteService(int serviceID) {
        return bookingCtrl.canDeleteService(serviceID);
    }
}
