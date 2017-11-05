/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.BookingDetail1BLL;
import model.Service;
import model.ServiceBLL;

/**
 *
 * @author sev_user
 */
public class ServiceManagePanel extends javax.swing.JPanel {

    private static ServiceBLL mServiceBLL;
    private static BookingDetail1BLL mBookingDetail1BLL;
    private static Service mService;
    private static int selectedServiceID = 0; // default = 0: not selected any row
    private static int selectedRow = -1;
    private DocumentListener dcListener;
    private static Vector origninalTableModel;

    /**
     * Creates new form ServiceManagePanel1
     */
    public ServiceManagePanel() {
        initComponents();
        mServiceBLL = new ServiceBLL();
        mBookingDetail1BLL = new BookingDetail1BLL();

        loadData(mServiceBLL.getAllService());

        addDocumentListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddService = new javax.swing.JButton();
        btnUpdateService = new javax.swing.JButton();
        btnDeleteService = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServiceList = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtServiceName = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddService.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnAddService.setText("Add Service");
        btnAddService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServiceActionPerformed(evt);
            }
        });
        add(btnAddService, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 570, 160, 50));

        btnUpdateService.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnUpdateService.setText("Update Service");
        btnUpdateService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateServiceActionPerformed(evt);
            }
        });
        add(btnUpdateService, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 570, 160, 50));

        btnDeleteService.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnDeleteService.setText("Delete Service");
        btnDeleteService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteServiceActionPerformed(evt);
            }
        });
        add(btnDeleteService, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, 160, 50));

        tblServiceList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Service ID", "Service Name", "Price", "Unit in Stock", "Status"
            }
        ));
        tblServiceList.setRowHeight(22);
        jScrollPane1.setViewportView(tblServiceList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 97, 1112, 456));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Search Service");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 140, 30));

        txtServiceName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtServiceName.setText("Service Name");
        txtServiceName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtServiceNameFocusLost(evt);
            }
        });
        txtServiceName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtServiceNameMouseClicked(evt);
            }
        });
        add(txtServiceName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 140, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceActionPerformed
        AddServiceForm.getObject().setVisible(true);
    }//GEN-LAST:event_btnAddServiceActionPerformed

    private void btnUpdateServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateServiceActionPerformed
        mService = new Service();
        selectedRow = tblServiceList.getSelectedRow();

        if (selectedRow == -1 || tblServiceList.getValueAt(selectedRow, 0) == null) {
            JOptionPane.showMessageDialog(this, "select service to update!!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int serviceID = Integer.parseInt(tblServiceList.getValueAt(selectedRow, 0).toString());
            if (mBookingDetail1BLL.isServiceUsing(serviceID) > 0) {
                JOptionPane.showMessageDialog(this, "This service is using in some bookings!!", "warning", JOptionPane.WARNING_MESSAGE);
            } else {
                mService.setServiceID(serviceID);
                mService.setServiceName(((String) tblServiceList.getValueAt(selectedRow, 1)));
                mService.setServicePrice(Float.parseFloat((String) tblServiceList.getValueAt(selectedRow, 2)));
                mService.setServiceQuantity(Integer.parseInt((String) tblServiceList.getValueAt(selectedRow, 3)));

                String status = tblServiceList.getValueAt(selectedRow, 4).toString();
                if (status.equals("Available")) {
                    mService.setStatus(0);
                } else {
                    mService.setStatus(1);
                }

                AddServiceForm.getObject1(mService).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnUpdateServiceActionPerformed

    private void btnDeleteServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteServiceActionPerformed
        selectedRow = tblServiceList.getSelectedRow();
        if (selectedRow == -1 || tblServiceList.getValueAt(selectedRow, 0) == null) {
            JOptionPane.showMessageDialog(this, "select service to delete!!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int serviceID = Integer.parseInt(tblServiceList.getValueAt(selectedRow, 0).toString());

            if (mBookingDetail1BLL.canDeleteService(serviceID) > 0) {
                JOptionPane.showMessageDialog(this, "Can not delete!! This service is using in some bookings!!", "warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int ask = JOptionPane.showConfirmDialog(this, "Do you really want to delete this service?", "Warning", JOptionPane.YES_NO_OPTION);
                if (ask == JOptionPane.YES_OPTION) {
                    selectedServiceID = Integer.parseInt((String) tblServiceList.getValueAt(selectedRow, 0));
                    mServiceBLL.deleteService(selectedServiceID);
                    loadData(mServiceBLL.getAllService());
                }
            }
        }
    }//GEN-LAST:event_btnDeleteServiceActionPerformed

    private void txtServiceNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtServiceNameMouseClicked
        txtServiceName.getDocument().addDocumentListener(dcListener);
        txtServiceName.selectAll();
    }//GEN-LAST:event_txtServiceNameMouseClicked

    private void txtServiceNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtServiceNameFocusLost
        txtServiceName.getDocument().removeDocumentListener(dcListener);
        if (txtServiceName.getText().equals("")) {
            txtServiceName.setText("Service name");
        }
    }//GEN-LAST:event_txtServiceNameFocusLost

    private void addDocumentListener() {
        dcListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }

            private void search() {
                searchByName(txtServiceName.getText());
            }
        };
    }

    private void searchByName(String serviceName) {
        DefaultTableModel tblServiceModel = (DefaultTableModel) tblServiceList.getModel();
        tblServiceModel.setRowCount(0);

        for (Object rows : origninalTableModel) {
            Vector rowVector = (Vector) rows;
            if (rowVector.get(1).toString().contains(serviceName)) {
                tblServiceModel.addRow(rowVector);
            }
        }
    }

    public static void loadData(ResultSet mRs) {
        DefaultTableModel tblServicelistModel = (DefaultTableModel) tblServiceList.getModel();
        tblServicelistModel.setRowCount(0);
        try {
            while (mRs.next()) {
                String status;
                if (mRs.getInt(5) == 0) {
                    status = "Available";
                } else {
                    status = "Out of Stock";
                }
                String[] data = {mRs.getString("serviceID"), mRs.getString("serviceName"), mRs.getString("servicePrice"),
                    mRs.getString("serviceQuantity"), status};
                tblServicelistModel.addRow(data);
            }

            tblServiceList.setModel(tblServicelistModel);
        } catch (SQLException ex) {
            Logger.getLogger(RoomManagePanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        origninalTableModel = (Vector) ((DefaultTableModel) tblServiceList.getModel()).getDataVector().clone();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddService;
    private javax.swing.JButton btnDeleteService;
    private javax.swing.JButton btnUpdateService;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tblServiceList;
    private javax.swing.JTextField txtServiceName;
    // End of variables declaration//GEN-END:variables
}
