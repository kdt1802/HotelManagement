/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows 10 Gamer
 */
public class ManagerForm extends javax.swing.JFrame {

    LoginForm parent;

    /**
     * Creates new form ManagerForm
     *
     * @param parent
     */
    public ManagerForm(LoginForm parent) {
        initComponents();
        setLocationRelativeTo(null);
        
        this.parent = parent;
        getPanel(new ViewReportPanel());
        lbUserName.setText(parent.mUser.getUserName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnContent = new javax.swing.JPanel();
        lbUserName = new javax.swing.JLabel();
        btnViewReport = new javax.swing.JButton();
        btnManageRoom = new javax.swing.JButton();
        btnServiceManage = new javax.swing.JButton();
        btnChangePass = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        lbUserName1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager");
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnContent.setBackground(new java.awt.Color(255, 255, 255));
        pnContent.setLayout(new java.awt.BorderLayout());
        jPanel1.add(pnContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 1190, 640));

        lbUserName.setFont(new java.awt.Font("Informal011 BT", 3, 18)); // NOI18N
        lbUserName.setForeground(new java.awt.Color(0, 255, 0));
        lbUserName.setText("Manager");
        jPanel1.add(lbUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 130, -1));

        btnViewReport.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnViewReport.setText("View Report");
        btnViewReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewReportActionPerformed(evt);
            }
        });
        jPanel1.add(btnViewReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 160, 50));

        btnManageRoom.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnManageRoom.setText("Manage Room");
        btnManageRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageRoomActionPerformed(evt);
            }
        });
        jPanel1.add(btnManageRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 160, 50));

        btnServiceManage.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnServiceManage.setText("Manage Service");
        btnServiceManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiceManageActionPerformed(evt);
            }
        });
        jPanel1.add(btnServiceManage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 160, 50));

        btnChangePass.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnChangePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icon/if_engineering__gear__setting__process__2568275 (1).png"))); // NOI18N
        btnChangePass.setText("Setting");
        btnChangePass.setToolTipText("");
        btnChangePass.setIconTextGap(10);
        btnChangePass.setMargin(new java.awt.Insets(2, 5, 2, 20));
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });
        jPanel1.add(btnChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 120, 30));

        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icon/if_Erase_32464.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setIconTextGap(10);
        btnLogout.setMargin(new java.awt.Insets(2, 5, 2, 20));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 60, 120, 30));

        jLabel2.setFont(new java.awt.Font("Informal011 BT", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hotel Management System");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1410, 20));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icon/if_User_Administrator_2_1218717.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 10, 120, 110));

        lbUserName1.setFont(new java.awt.Font("Informal011 BT", 3, 18)); // NOI18N
        lbUserName1.setForeground(new java.awt.Color(0, 255, 0));
        lbUserName1.setText("WElcome");
        jPanel1.add(lbUserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/picture/pattern-wood-background-1920-x-1200-id-79603.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 830));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageRoomActionPerformed
        getPanel(new RoomManagePanel());
    }//GEN-LAST:event_btnManageRoomActionPerformed

    private void btnViewReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewReportActionPerformed
        getPanel(new ViewReportPanel());
    }//GEN-LAST:event_btnViewReportActionPerformed

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        ChangePasswordForm.getObject("ManagerForm", parent.mUser).setVisible(true);
    }//GEN-LAST:event_btnChangePassActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int ask = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Warning", JOptionPane.YES_NO_OPTION);
        if (ask == JOptionPane.YES_OPTION) {
            parent.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnServiceManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiceManageActionPerformed
        getPanel(new ServiceManagePanel());
    }//GEN-LAST:event_btnServiceManageActionPerformed

    public static void getPanel(Component panel) {
        pnContent.removeAll();
        pnContent.setVisible(false);
        pnContent.add(panel);
        pnContent.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageRoom;
    private javax.swing.JButton btnServiceManage;
    private javax.swing.JButton btnViewReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JLabel lbUserName1;
    private static javax.swing.JPanel pnContent;
    // End of variables declaration//GEN-END:variables
}
