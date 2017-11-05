/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ConnectionManager;
import controller.User_Controller;
import java.sql.ResultSet;

/**
 *
 * @author sev_user
 */
public class UserBLL {

    User_Controller userControl;

    public UserBLL() {
        userControl = new User_Controller(ConnectionManager.getConnection());
    }

    public User getUserLogin(String username, String password) {
        return userControl.getUserLogin(username, password);
    }

    public ResultSet getAllUser() {
        return userControl.getAll();
    }

    public ResultSet getUserByName(String name) {
        return userControl.getByName(name);
    }

    public int updateUser(User user) {
        return userControl.update(user);
    }

    public int insertUser(User user) {
        return userControl.insert(user);
    }

    public int deleteUser(int id) {
        return userControl.delete(id);
    }

    public int checkUserExistence(User user) {
        return userControl.checkUserExistence(user);
    }

    public int changePassword(User user) {
        return userControl.changePassword(user);
    }

    public int resetPassword(int selectedUserID) {
        return userControl.resetPassword(selectedUserID);
    }
    
    public void closeConnetion() {
        userControl.closeConnection();
    }
}
