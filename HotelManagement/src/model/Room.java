/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sev_user
 */
public class Room {
    private int roomID;
    private int roomType;
    private int roomNumber;
    private float nightPrice;
    private float hourPrice;
    private int status;

    public Room() {
    }

    public Room(int roomID, int roomType, int roomNumber, float nightPrice, float hourPrice, int status) {
        this.roomID = roomID;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.nightPrice = nightPrice;
        this.hourPrice = hourPrice;
        this.status = status;
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
}
