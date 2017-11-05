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
import model.Client;

/**
 *
 * @author sev_user
 */
public class Client_Controller {

    Connection mCon;

    public Client getClientById(int ID) {
        Client mClient = new Client();
        String sql = "select * from CLIENT where clientID = " + ID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                mClient.setClientID(rs.getInt(1));
                mClient.setClientName(rs.getString(2));
                mClient.setClientPhone(rs.getString(3));
                mClient.setClientIDCard(rs.getString(4));
            }
            return mClient;
        } catch (SQLException ex) {
            return null;
        }
    }

    public int getLatestClientID() {
        int ID = 0;
        String sql = "select MAX(clientID) from CLIENT";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                ID = rs.getInt(1);
            }
            System.out.println(ID);
        } catch (SQLException ex) {
            return 0;
        }
        return ID;
    }

    public int addNewClient(Client client) {
        String sql = "insert into CLIENT values(?,?,?)";
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            prStm.setString(1, client.getClientName());
            prStm.setString(2, "" + client.getClientPhone());
            prStm.setString(3, "" + client.getClientIDCard());

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int updateClient(Client client) {
        String sql = "Update CLIENT set clientName = ?, clientPhone = ?, client_ID_Card = ? Where clientID = ?";

        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            prStm.setString(1, client.getClientName());
            prStm.setString(2, "" + client.getClientPhone());
            prStm.setString(3, "" + client.getClientIDCard());
            prStm.setString(4, "" + client.getClientID());

            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public int deleteByID(int ID) {
        String sql = "DELETE from CLIENT where clientID = " + ID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            return prStm.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public String getNameById(int ID) {
        String name = "";
        String sql = "select clientName from CLIENT where clientID = " + ID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                name = rs.getString("clientName");
            }
        } catch (SQLException ex) {
            return name;
        }
        return name;
    }

    public String getPhoneByID(int ID) {
        String phone = "";
        String sql = "select clientPhone from CLIENT where clientID = " + ID;
        try {
            mCon = ConnectionManager.getConnection();
            PreparedStatement prStm = mCon.prepareStatement(sql);
            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                phone = rs.getString("clientPhone");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return phone;
        }
        return phone;
    }
}
