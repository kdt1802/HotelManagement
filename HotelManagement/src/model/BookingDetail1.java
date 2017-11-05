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
public class BookingDetail1 {
    private int bookingID;
    private int serviceID;
    private String serviceName;
    private int serviceQuantity;
    private float servicePrice;
    private int status; // 0 = not using in any Booking, 1 = using in some bookings
    
    public BookingDetail1() {
    }

    public BookingDetail1(int bookingID, int serviceID, int serviceQuantity, float servicePrice) {
        this.bookingID = bookingID;
        this.serviceID = serviceID;
        this.serviceQuantity = serviceQuantity;
        this.servicePrice = servicePrice;
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
     * @return the serviceID
     */
    public int getServiceID() {
        return serviceID;
    }

    /**
     * @param serviceID the serviceID to set
     */
    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    /**
     * @return the serviceQuantity
     */
    public int getServiceQuantity() {
        return serviceQuantity;
    }

    /**
     * @param serviceQuantity the serviceQuantity to set
     */
    public void setServiceQuantity(int serviceQuantity) {
        this.serviceQuantity = serviceQuantity;
    }

    /**
     * @return the servicePrice
     */
    public float getServicePrice() {
        return servicePrice;
    }

    /**
     * @param servicePrice the servicePrice to set
     */
    public void setServicePrice(float servicePrice) {
        this.servicePrice = servicePrice;
    }   

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
