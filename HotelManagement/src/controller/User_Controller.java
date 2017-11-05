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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author sev_user
 */
public class User_Controller extends IDAO<User> {

    public User_Controller(Connection conn) {
        this.conn = conn;
        try {
            this.stm = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ResultSet getAll() {
        try {
            String sql = "select * from [user]";
            rs = stm.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(User_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    @Override
    public ResultSet getByName(String name) {
        try {
            String sql = "select * from [user] where userName = '" + name + "'";
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(User_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    @Override
    public int insert(User obj) {
        String sql = "INSERT INTO [USER] VALUES (?,?,?,?,?)";
        try {
            this.preStm = this.conn.prepareStatement(sql);

            preStm.setString(1, obj.getUserName());
            preStm.setString(2, obj.getUserPass());
            preStm.setInt(3, obj.getUserPhone());
            preStm.setInt(4, obj.getPosition());
            preStm.setInt(5, obj.getStatus());
            preStm.executeUpdate();
            System.out.println(obj.getUserName());
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(User_Controller.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int update(User obj) {
        String sql = "UPDATE [USER] SET  UserName = ?, UserPhone = ?, Position = ?, Status = ? where userID = '" + obj.getUserID() + "'";
        try {
            this.preStm = this.conn.prepareStatement(sql);
            //preStm.setInt(1, obj.getUserID());
            preStm.setString(1, obj.getUserName());
            preStm.setInt(2, obj.getUserPhone());
            preStm.setInt(3, obj.getPosition());
            preStm.setInt(4, obj.getStatus());
            preStm.executeUpdate();
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(User_Controller.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM [USER] WHERE userID = " + id;
        try {
            stm.executeUpdate(sql);
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(User_Controller.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    public int checkUserExistence(User obj) {
        String sql = "SELECT * FROM [USER]  WHERE userName = ? AND userPass = ? ";
        try {
            this.preStm = this.conn.prepareStatement(sql);
            preStm.setString(1, obj.getUserName());
            preStm.setString(2, obj.getUserPass());
            this.rs = preStm.executeQuery();
            if (rs.next()) {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int changePassword(User obj) {
        String sql = "UPDATE [USER] SET UserPass = ? WHERE userName = ?";
        try {
            this.preStm = this.conn.prepareStatement(sql);
            preStm.setString(1, obj.getUserPass());
            preStm.setString(2, obj.getUserName());

            preStm.executeUpdate();
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(User_Controller.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public User getUserLogin(String username, String password) {
        User mUser = new User();
        mUser.setUserPass("-1");
        try {
            String sql = "select * from [user] where userName = '" + username + "' AND userPass = '" + password + "'";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                mUser.setUserID(rs.getInt(1));
                mUser.setUserName(rs.getString(2));
                mUser.setUserPass(rs.getString(3));
                mUser.setUserPhone(rs.getInt(4));
                mUser.setPosition(rs.getInt(5));
                mUser.setStatus(rs.getInt(6));
            }

            return mUser;
        } catch (SQLException ex) {
            return null;
        }
    }

    public int resetPassword(int selectedUserID) {
        String sql = "UPDATE [USER] SET UserPass = 1 WHERE userID = " + selectedUserID;
        try {
            this.preStm = this.conn.prepareStatement(sql);

            preStm.executeUpdate();
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(User_Controller.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public void closeConnection() {
        if (conn != null) {
            ConnectionManager.closeConnection(conn);
            System.out.println("closed");
        }
    }

}
