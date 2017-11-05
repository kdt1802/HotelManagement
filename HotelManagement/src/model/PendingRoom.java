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
public class PendingRoom {

    private int roomID;
    private int roomType;
    private int roomNumber;
    private float nightPrice;
    private float hourPrice;
    private float totalprice;
    private int status;
    private Date checkinTime;
    private Date checkoutTime;

    public PendingRoom() {
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
     * @return the roomType
     */
    public int getRoomType() {
        return roomType;
    }

    /**
     * @param roomType the roomType to set
     */
    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    /**
     * @return the roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return the nightPrice
     */
    public float getNightPrice() {
        return nightPrice;
    }

    /**
     * @param nightPrice the nightPrice to set
     */
    public void setNightPrice(float nightPrice) {
        this.nightPrice = nightPrice;
    }

    /**
     * @return the hourPrice
     */
    public float getHourPrice() {
        return hourPrice;
    }

    /**
     * @param hourPrice the hourPrice to set
     */
    public void setHourPrice(float hourPrice) {
        this.hourPrice = hourPrice;
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
}
