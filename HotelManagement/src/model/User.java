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
public class User {

    private int userID;
    private String userName;
    private String userPass;
    private int userPhone;
    private int position;
    private int status;

    public User() {
    }

    public User(int userID, String userName, String userPass, int userPhone, int position, int status) {
        this.userID = userID;
        this.userName = userName;
        this.userPass = userPass;
        this.userPhone = userPhone;
        this.position = position;
        this.status = status;
    }

    public User(String userName, String userPass, int userPhone, int position, int status) {
        this.userName = userName;
        this.userPass = userPass;
        this.userPhone = userPhone;
        this.position = position;
        this.status = status;
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
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userPass
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * @param userPass the userPass to set
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    /**
     * @return the userPhone
     */
    public int getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone the userPhone to set
     */
    public void setUserPhone(int userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
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
