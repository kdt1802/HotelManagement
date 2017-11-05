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
public class Booking {

    private int BookingID;
    private int clientID;
    private String note;
    private Date bookingTime;
    private float estimatePrice;
    private int status;

    public Booking() {
    }

    public Booking(int BookingID, int clientID, String note, Date bookingTime, float estimatePrice, int status) {
        this.BookingID = BookingID;
        this.clientID = clientID;
        this.note = note;
        this.bookingTime = bookingTime;
        this.estimatePrice = estimatePrice;
        this.status = status;
    }

    public Booking(int clientID, String note, Date bookingTime, float estimatePrice, int status) {
        this.clientID = clientID;
        this.note = note;
        this.bookingTime = bookingTime;
        this.estimatePrice = estimatePrice;
        this.status = status;
    }

    /**
     * @return the BookingID
     */
    public int getBookingID() {
        return BookingID;
    }

    /**
     * @param BookingID the BookingID to set
     */
    public void setBookingID(int BookingID) {
        this.BookingID = BookingID;
    }

    /**
     * @return the clientID
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * @param clientID the clientID to set
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the bookingTime
     */
    public Date getBookingTime() {
        return bookingTime;
    }

    /**
     * @param bookingTime the bookingTime to set
     */
    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    /**
     * @return the estimatePrice
     */
    public float getEstimatePrice() {
        return estimatePrice;
    }

    /**
     * @param estimatePrice the estimatePrice to set
     */
    public void setEstimatePrice(float estimatePrice) {
        this.estimatePrice = estimatePrice;
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
