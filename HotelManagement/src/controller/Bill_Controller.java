/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sev_user
 */
public class Bill_Controller {

    Connection mCon;

    public int addNewBill(int userID, int bookingID, Date billDate) {
        String sql = "INSERT INTO BILL VALUES(?,?,?)";
        DateFormat mDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String billDateString = mDateFormat.format(billDate);
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            prStm.setString(1, "" + userID);
            prStm.setString(2, "" + bookingID);
            prStm.setString(3, billDateString);

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int deleteByBookingID(int bookingID) {
        String sql = "DELETE from BILL where bookingID = " + bookingID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int deleteByUserID(int userID) {
        String sql = "DELETE from BILL where userID = " + userID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }
}
