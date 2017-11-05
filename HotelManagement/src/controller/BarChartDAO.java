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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TuanTA
 */
public class BarChartDAO {
    public float getAmountByMonthAndYear(int month, int year) {
        float amount = 0;
        Connection conn = ConnectionManager.getConnection();
        String sql = "SELECT SUM(dbo.BOOKING.estimatePrice)\n"
                + "FROM   dbo.BILL INNER JOIN dbo.BOOKING \n"
                + "ON     dbo.BILL.bookingID = dbo.BOOKING.bookingID\n"
                + "Where  DATEPART(MM,dbo.BILL.billDate) = ?\n"
                + "AND    DATEPART(YY,dbo.BILL.billDate) = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, month);
            ps.setInt(2, year);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                amount = rs.getFloat(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarChartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount;
    }
}
