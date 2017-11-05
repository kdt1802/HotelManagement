/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author sev_user
 */
public class BookingDetail {

    private int bookingID;
    private int roomID;
    private float roomPrice;
    private Date checkinTime;
    private Date checkoutTime;
    private int status;

    public BookingDetail() {
    }

    public BookingDetail(int bookingID, int roomID, float roomPrice, Date checkinTime, Date checkoutTime) {
        this.bookingID = bookingID;
        this.roomID = roomID;
        this.roomPrice = roomPrice;
        this.checkinTime = checkinTime;
        this.checkoutTime = checkoutTime;
    }

    /**
     * @return the bookingID
     */
    public int getBookingID() {
        return bookingID;
    }

    /**
     * @param bookingID the bookingID to set
     */
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    /**
     * @return the roomID
     */
    public int getRoomID() {
        return roomID;
    }

    /**
     * @param roomID the roomID to set
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    /**
     * @return the roomPrice
     */
    public float getRoomPrice() {
        return roomPrice;
    }

    /**
     * @param roomPrice the roomPrice to set
     */
    public void setRoomPrice(float roomPrice) {
        this.roomPrice = roomPrice;
    }

    /**
     * @return the checkinTime
     */
    public Date getCheckinTime() {
        return checkinTime;
    }

    /**
     * @param checkinTime the checkinTime to set
     */
    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    /**
     * @return the checkoutTime
     */
    public Date getCheckoutTime() {
        return checkoutTime;
    }

    /**
     * @param checkoutTime the checkoutTime to set
     */
    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
