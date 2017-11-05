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
public class Client {
    private int clientID;
    private String clientName;
    private String clientPhone;
    private String clientIDCard;

    public Client() {
    }

    public Client(int clientID, String clientName, String clientPhone, String clientIDCard) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientIDCard = clientIDCard;
    }

    public Client(String clientName, String clientPhone, String clientIDCard) {
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientIDCard = clientIDCard;
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
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the clientPhone
     */
    public String getClientPhone() {
        return clientPhone;
    }

    /**
     * @param clientPhone the clientPhone to set
     */
    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    /**
     * @return the clientIDCard
     */
    public String getClientIDCard() {
        return clientIDCard;
    }

    /**
     * @param clientIDCard the clientIDCard to set
     */
    public void setClientIDCard(String clientIDCard) {
        this.clientIDCard = clientIDCard;
    }   
}
