/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Bill_Controller;
import java.util.Date;

/**
 *
 * @author sev_user
 */
public class BillBLL {
    Bill_Controller mBillCtrl = new Bill_Controller();
    
    public int addNewBill(int userID, int bookingID, Date billDate) {
        return mBillCtrl.addNewBill(userID, bookingID, billDate);
    }
    
    public int deleteByBookingID(int bookingID) {
        return mBillCtrl.deleteByBookingID(bookingID);
    }

    public int deleteByUserID(int userID) {
        return mBillCtrl.deleteByUserID(userID);
    }
}
