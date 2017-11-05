/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Service;

/**
 *
 * @author sev_user
 */
public class Service_Controller {

    public ResultSet getServiceAvailable() {
        Connection mCon;
        String sql = "select * from SERVICE where status = 0";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeQuery();

        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet getServiceByID(int serviceID) {
        Connection mCon;
        String sql = "select * from SERVICE where serviceID = " + serviceID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeQuery();
        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet getServiceByName(String serviceName) {
        Connection mCon;
        String sql = "select * from SERVICE where serviceName = '" + serviceName + "'";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeQuery();

        } catch (SQLException ex) {
            return null;
        }
    }

    public int addService(Service service) {
        Connection mCon;
        String sql = "INSERT INTO SERVICE(serviceName, servicePrice, serviceQuantity, status) VALUES(?,?,?,?)";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            prStm.setString(1, "" + service.getServiceName());
            prStm.setString(2, "" + service.getServicePrice());
            prStm.setString(3, "" + service.getServiceQuantity());
            prStm.setString(4, "" + service.getStatus());

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int updateServive(Service service) {
        Connection mCon;
        String sql = "UPDATE SERVICE SET serviceName = ?, servicePrice = ?, serviceQuantity = ?, status = ? where serviceID = " + service.getServiceID();

        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            prStm.setString(1, "" + service.getServiceName());
            prStm.setString(2, "" + service.getServicePrice());
            prStm.setString(3, "" + service.getServiceQuantity());
            prStm.setString(4, "" + service.getStatus());

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int deleteService(int serviceID) {
        Connection mCon;
        String sql = "DELETE FROM SERVICE WHERE serviceID = " + serviceID;

        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int updateService(int serviceID, int newUnit, int newStatus) {
        Connection mCon;
        String sql = "UPDATE SERVICE SET serviceQuantity = ?, status = ? where serviceID = " + serviceID;

        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            prStm.setString(1, "" + newUnit);
            prStm.setString(2, "" + newStatus);

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public ResultSet getAllService() {
        Connection mCon = null;
        String sql = "select * from SERVICE";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeQuery();
        } catch (SQLException ex) {
            return null;
        } finally {
            if (mCon != null) {
                ConnectionManager.closeConnection(mCon);
            }
        }
    }
}
