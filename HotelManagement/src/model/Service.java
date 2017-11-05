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
public class Service {
    private int serviceID;
    private String serviceName;
    private float servicePrice;
    private int serviceQuantity;
    private int status;

    public Service() {
    }

    public Service(int serviceID, String serviceName, float servicePrice, int serviceQuantity, int status) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.serviceQuantity = serviceQuantity;
        this.status = status;
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
