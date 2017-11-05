/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author sev_user
 */
public class Bill {
    private int bill_ID;
    private int userID;
    private int bookingID;
    private Date billDate;

    public Bill() {
    }

    public Bill(int bill_ID, int userID, int bookingID, Date billDate) {
        this.bill_ID = bill_ID;
        this.userID = userID;
        this.bookingID = bookingID;
        this.billDate = billDate;
    }

    
    /**
     * @return the bill_ID
     */
    public int getBill_ID() {
        return bill_ID;
    }

    /**
     * @param bill_ID the bill_ID to set
     */
    public void setBill_ID(int bill_ID) {
        this.bill_ID = bill_ID;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
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
     * @return the billDate
     */
    public Date getBillDate() {
        return billDate;
    }

    /**
     * @param billDate the billDate to set
     */
    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }
}
