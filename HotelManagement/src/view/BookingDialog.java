/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Room_Controller;
import controller.ToolCheckInput;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Booking;
import model.BookingBLL;
import model.BookingDetail;
import model.BookingDetail1;
import model.BookingDetail1BLL;
import model.BookingDetailBLL;
import model.Client;
import model.ClientBLL;
import model.PendingRoom;
import model.Service;
import model.ServiceBLL;
import model.User;

/**
 *
 * @author sev_user
 */
public class BookingDialog extends java.awt.Dialog {

    User mUser;
    Booking mBooking;
    BookingBLL mBookingBLL;
    BookingDetailBLL mBookingDTBLL;
    BookingDetail1BLL mBookingDT1BLL;
    Client mClient;
    ClientBLL mClientBLL;
    ServiceBLL mServiceBLL;
    private static int selectedRow;
    int bookingID;
    public static float estPrice; // estimate price
    public static ArrayList<PendingRoom> listRoomPending;
    public static ArrayList<BookingDetail1> listServicePending;
    public static ArrayList<Service> listServiceAvailable;
    public static ArrayList<Integer> listRoomRemove = new ArrayList<>();
    public static ArrayList<Integer> listServiceRemove = new ArrayList<>();
    private static DecimalFormat df = new DecimalFormat("#.##");

    /**
     * Creates new form BookingDialog
     *
     * @param parent
     * @param modal
     */
    public BookingDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        btnSave.setEnabled(false);
        btnExportBill.setEnabled(false);
        mBookingBLL = new BookingBLL();
        mBookingDTBLL = new BookingDetailBLL();
        mBookingDT1BLL = new BookingDetail1BLL();
        mClientBLL = new ClientBLL();
        mServiceBLL = new ServiceBLL();

        btnReBooking.setVisible(false);
        selectedRow = -1;
        estPrice = 0;
        bookingID = -1;
        listRoomPending = new ArrayList<>();
        listServicePending = new ArrayList<>();
        listServiceAvailable = new ArrayList<>();
        try {
            ResultSet rs = mServiceBLL.getAllService();
            while (rs.next()) {
                Service mService = new Service();
                mService.setServiceID(rs.getInt(1));
                mService.setServiceName(rs.getString(2));
                mService.setServicePrice(rs.getFloat(3));
                mService.setServiceQuantity(rs.getInt(4));
                mService.setStatus(rs.getInt(5));

                listServiceAvailable.add(mService);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BookingDialog(java.awt.Frame parent, boolean modal, String father, User mUser, Booking mBooking, Client mClient, ArrayList<PendingRoom> mListRoom, ArrayList<BookingDetail1> mListService) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        btnCreateBooking.setEnabled(false);
        mBookingBLL = new BookingBLL();
        mBookingDTBLL = new BookingDetailBLL();
        mBookingDT1BLL = new BookingDetail1BLL();
        mClientBLL = new ClientBLL();
        mServiceBLL = new ServiceBLL();
        estPrice = 0;
        selectedRow = -1;

        this.mBooking = mBooking;
        this.bookingID = mBooking.getBookingID();
        this.mClient = mClient;
        this.mUser = mUser;
        listRoomPending = mListRoom;
        loadRoom();
        listServicePending = mListService;
        loadService();
        listServiceAvailable = new ArrayList<>();
        try {
            ResultSet rs = mServiceBLL.getAllService();
            while (rs.next()) {
                Service mService = new Service();
                mService.setServiceID(rs.getInt(1));
                mService.setServiceName(rs.getString(2));
                mService.setServicePrice(rs.getFloat(3));
                mService.setServiceQuantity(rs.getInt(4));
                mService.setStatus(rs.getInt(5));

                listServiceAvailable.add(mService);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtClientName.setText(mClient.getClientName());
        txtClientPhone.setText("" + mClient.getClientPhone());
        txtIDCard.setText("" + mClient.getClientIDCard());
        txtNote.setText(mBooking.getNote());
        btnReBooking.setVisible(false);

        //If booking is checked-out or canceled or called by managerForm then disable all modifier
        if (mBooking.getStatus() >= 2 || father.equals("manager")) {
            txtClientName.setEditable(false);
            txtClientPhone.setEditable(false);
            txtIDCard.setEditable(false);
            txtNote.setEditable(false);
            txtEstPrice.setEditable(false);

            btnAddRoom.setEnabled(false);
            btnRemoveRoom.setEnabled(false);
            btnRoomDetail.setEnabled(false);
            btnAddService.setEnabled(false);
            btnUpdateService.setEnabled(false);
            btnRemoveService.setEnabled(false);
            btnCreateBooking.setEnabled(false);
            btnSave.setEnabled(false);
            btnCheckin.setEnabled(false);
            btnCheckout.setEnabled(false);
            btnExportBill.setEnabled(false);
        }

        if (mBooking.getStatus() == 3) {
            btnReBooking.setVisible(true);
        }

        for (int i = 0; i < tblRoomDetail.getRowCount(); i++) {
            estPrice += Float.parseFloat(tblRoomDetail.getValueAt(i, 5).toString());
        }

        for (int i = 0; i < tblService.getRowCount(); i++) {
            estPrice += Float.parseFloat(tblService.getValueAt(i, 4).toString());
        }

        txtEstPrice.setText(df.format(estPrice));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtClientName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtClientPhone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIDCard = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRoomDetail = new javax.swing.JTable();
        btnCreateBooking = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtEstPrice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblService = new javax.swing.JTable();
        btnAddService = new javax.swing.JButton();
        btnRemoveService = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnAddRoom = new javax.swing.JButton();
        btnRemoveRoom = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnRoomDetail = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnCheckin = new javax.swing.JButton();
        btnCheckout = new javax.swing.JButton();
        btnExportBill = new javax.swing.JButton();
        btnReBooking = new javax.swing.JButton();
        btnUpdateService = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Client Name");

        jLabel3.setText("Client Phone");

        jLabel4.setText("Client ID card");

        jLabel8.setText("Client's Information");

        jLabel9.setText("Room Detail");

        tblRoomDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Room ID", "Room Number", "Room type", "Checkin Time", "Checkout Time", "Price", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblRoomDetail);

        btnCreateBooking.setText("Create new Booking");
        btnCreateBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateBookingActionPerformed(evt);
            }
        });

        jLabel6.setText("Estimate Price");

        txtEstPrice.setEditable(false);

        txtNote.setColumns(20);
        txtNote.setRows(5);
        txtNote.setText("Note");
        jScrollPane2.setViewportView(txtNote);

        tblService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Service ID", "Service name", "Price", "Quantity", "Total"
            }
        ));
        jScrollPane3.setViewportView(tblService);

        btnAddService.setText("Add Service");
        btnAddService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServiceActionPerformed(evt);
            }
        });

        btnRemoveService.setText("Remove");
        btnRemoveService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveServiceActionPerformed(evt);
            }
        });

        jLabel10.setText("Service detail");

        btnAddRoom.setText("Add Room");
        btnAddRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRoomActionPerformed(evt);
            }
        });

        btnRemoveRoom.setText("Remove");
        btnRemoveRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveRoomActionPerformed(evt);
            }
        });

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnRoomDetail.setText("Detail");
        btnRoomDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoomDetailActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("VnTimes", 0, 24)); // NOI18N
        jLabel1.setText("Booking Form");

        btnCheckin.setText("Checkin");
        btnCheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckinActionPerformed(evt);
            }
        });

        btnCheckout.setText("Checkout");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        btnExportBill.setText("Export Bill");
        btnExportBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportBillActionPerformed(evt);
            }
        });

        btnReBooking.setText("Re-booking");
        btnReBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReBookingActionPerformed(evt);
            }
        });

        btnUpdateService.setText("Update");
        btnUpdateService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateServiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(589, 589, 589)
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtEstPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btnAddService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnRemoveService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnUpdateService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnExportBill, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnReBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCreateBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnCheckin)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCheckout)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnRoomDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnRemoveRoom)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAddRoom))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(348, 348, 348)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addComponent(jLabel10)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtClientPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(txtIDCard, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(421, 421, 421)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtClientPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtIDCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddRoom)
                    .addComponent(btnRemoveRoom)
                    .addComponent(btnRoomDetail)
                    .addComponent(btnCheckin)
                    .addComponent(btnCheckout))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAddService)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateService)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveService))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportBill, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnCreateBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateBookingActionPerformed
        if (checkInput()) {
            //Create new Client
            String clientName = txtClientName.getText();
            String clientPhone = txtClientPhone.getText();
            String clientIDCard = txtIDCard.getText();

            Client client = new Client(clientName, clientPhone, clientIDCard);
            mClientBLL.addNewClient(client);

            //Create new booking
            int clientID = mClientBLL.getLatestClientID();
            String note = txtNote.getText();
            Date bookingTime = new Date();
            int status = 0; // Default la chua checkin

            Booking mbooking = new Booking(clientID, note, bookingTime, estPrice, status);
            mBookingBLL.addNewBooking(mbooking);

            //Create new BOOKING_DETAIL
            bookingID = mBookingBLL.getLatestBookingID();
            listRoomPending.stream().map((pendingRoom) -> {
                BookingDetail mbookingDetail = new BookingDetail();
                mbookingDetail.setBookingID(bookingID);
                mbookingDetail.setRoomID(pendingRoom.getRoomID());
                mbookingDetail.setRoomPrice(pendingRoom.getTotalprice());
                mbookingDetail.setCheckinTime(pendingRoom.getCheckinTime());
                mbookingDetail.setCheckoutTime(pendingRoom.getCheckoutTime());
                mbookingDetail.setStatus(pendingRoom.getStatus());

                return mbookingDetail;
            }).forEachOrdered((mbookingDetail) -> {
                mBookingDTBLL.addNewBookingDetail(mbookingDetail);
            });

            //Create new Booking_detail1 (for service it service table is not null)
            if (!listServicePending.isEmpty()) {
                for (BookingDetail1 pendingService : listServicePending) {
                    BookingDetail1 mBookingDetail1 = new BookingDetail1();

                    mBookingDetail1.setBookingID(bookingID);
                    mBookingDetail1.setServiceID(pendingService.getServiceID());
                    mBookingDetail1.setServiceName(pendingService.getServiceName());
                    mBookingDetail1.setServiceQuantity(pendingService.getServiceQuantity());
                    mBookingDetail1.setServicePrice(pendingService.getServicePrice());

                    mBookingDT1BLL.addNewBookingDetail_1(mBookingDetail1);
                }
            }
            if (!listServiceAvailable.isEmpty()) {
                for (Service service : listServiceAvailable) {
                    mServiceBLL.updateService(service.getServiceID(), service.getServiceQuantity(), service.getStatus());
                }
            }
            this.dispose();
            ReceptionistForm.loadData();
        }
    }//GEN-LAST:event_btnCreateBookingActionPerformed

    private void btnAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceActionPerformed
        //        SearchServiceForm.getObjcet().setVisible(true);
        SearchServiceDialog searchServiceDialog = new SearchServiceDialog(new javax.swing.JFrame("BookingService Detail"), true);
        searchServiceDialog.setTitle("Add Service");
        searchServiceDialog.setVisible(true);
    }//GEN-LAST:event_btnAddServiceActionPerformed

    private void btnRemoveServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveServiceActionPerformed
        selectedRow = tblService.getSelectedRow();

        if (selectedRow == -1 || tblService.getValueAt(selectedRow, 0) == null) {
            JOptionPane.showMessageDialog(this, "Select service to remove!!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int ask = JOptionPane.showConfirmDialog(this, "Do you want to remove this service??", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (ask == JOptionPane.YES_OPTION) {
                int serviceID = Integer.parseInt(tblService.getValueAt(selectedRow, 0).toString());
                // Add to remove list
                listServiceRemove.add(serviceID);

                for (BookingDetail1 pendingService : listServicePending) {
                    if (pendingService.getServiceID() == serviceID) {
                        listServicePending.remove(pendingService);
                        estPrice -= pendingService.getServicePrice();
                        txtEstPrice.setText(df.format(estPrice));
                        break;
                    }
                }

                int quantity = Integer.parseInt(tblService.getValueAt(selectedRow, 3).toString());
                for (Service service : listServiceAvailable) {
                    if (service.getServiceID() == serviceID) {
                        service.setServiceQuantity(service.getServiceQuantity() + quantity);
                        service.setStatus(0);
                    }
                }
                loadService();
            }
        }
    }//GEN-LAST:event_btnRemoveServiceActionPerformed

    private void btnAddRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRoomActionPerformed
        //        SearchFreeRoomForm.getObject().setVisible(true);
        SearchFreeRoomDialog searchFreeRoomDialog = new SearchFreeRoomDialog(new javax.swing.JFrame("BookingRoom Detail"), true);
        searchFreeRoomDialog.setTitle("Search free rooms");
        searchFreeRoomDialog.setVisible(true);
    }//GEN-LAST:event_btnAddRoomActionPerformed

    private void btnRemoveRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveRoomActionPerformed
        selectedRow = tblRoomDetail.getSelectedRow();

        if (selectedRow == -1 || tblRoomDetail.getValueAt(selectedRow, 6) == null) {
            JOptionPane.showMessageDialog(this, "Select room to remove!!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String status = tblRoomDetail.getValueAt(selectedRow, 6).toString();
            if (!status.equals("Booked")) {
                JOptionPane.showMessageDialog(this, "Already checked-in. Can not remove!!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int ask = JOptionPane.showConfirmDialog(this, "Do you want to remove this room??", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (ask == JOptionPane.YES_OPTION) {
                    int roomID = Integer.parseInt(tblRoomDetail.getValueAt(selectedRow, 0).toString());

                    //                    bookingDetailBLL.deleteBookingDetail(bookingID, roomID);
                    listRoomRemove.add(roomID);

                    // Remove from listRoomPending
                    for (PendingRoom pendingRoom : listRoomPending) {
                        if (pendingRoom.getRoomID() == roomID) {
                            listRoomPending.remove(pendingRoom);
                            estPrice -= pendingRoom.getTotalprice();
                            txtEstPrice.setText(df.format(estPrice));
                            break;
                        }
                    }
                }
                loadRoom();
            }
        }
    }//GEN-LAST:event_btnRemoveRoomActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (checkInput()) {
            //Update Client
            mClient.setClientName(txtClientName.getText());
            mClient.setClientPhone(txtClientPhone.getText());
            mClient.setClientIDCard(txtIDCard.getText());
            mClientBLL.updateClient(mClient);

            //Update booking
            int clientID = mClient.getClientID();
            String note = txtNote.getText();
            Date bookingTime = new Date();
            int status = 0; // Default la chua checkin

            Booking mbooking = new Booking(bookingID, clientID, note, bookingTime, estPrice, status);
            mBookingBLL.updateBooking(mbooking);

            //Update Booking status (status changes to checked-in if atleast 1 room checked-in)
            boolean isCheckin = false;
            if (!listRoomPending.isEmpty()) {
                for (PendingRoom pendingRoom : listRoomPending) {
                    if (pendingRoom.getStatus() == 1) {
                        isCheckin = true;
                        break;
                    }
                }
            }
            if (isCheckin) {
                mBookingBLL.checkIn(bookingID, 1);
            }

            //Update BOOKING_DETAIL
            if (!listRoomPending.isEmpty()) {
                for (PendingRoom pendingRoom : listRoomPending) {
                    BookingDetail mbookingDetail = new BookingDetail();
                    mbookingDetail.setBookingID(bookingID);
                    mbookingDetail.setRoomID(pendingRoom.getRoomID());
                    mbookingDetail.setRoomPrice(pendingRoom.getTotalprice());
                    mbookingDetail.setCheckinTime(pendingRoom.getCheckinTime());
                    mbookingDetail.setCheckoutTime(pendingRoom.getCheckoutTime());
                    mbookingDetail.setStatus(pendingRoom.getStatus());

                    if (mBookingDTBLL.getBookingDetail(bookingID, mbookingDetail.getRoomID()) > 0) {
                        mBookingDTBLL.updateBookingDetail(mbookingDetail);
                    } else {
                        mBookingDTBLL.addNewBookingDetail(mbookingDetail);
                    }
                }
            }

            if (!listRoomRemove.isEmpty()) {
                for (int roomID : listRoomRemove) {
                    if (bookingID != -1 && mBookingDTBLL.getBookingDetail(bookingID, roomID) > 0) {
                        mBookingDTBLL.deleteBookingDetail(bookingID, roomID);
                    }
                }
            }

            //Update Booking_detail1 (for service if service table is not null)
            if (!listServicePending.isEmpty()) {
                for (BookingDetail1 pendingService : listServicePending) {
                    BookingDetail1 mBookingDetail1 = new BookingDetail1();

                    mBookingDetail1.setBookingID(bookingID);
                    mBookingDetail1.setServiceID(pendingService.getServiceID());
                    mBookingDetail1.setServiceName(pendingService.getServiceName());
                    mBookingDetail1.setServiceQuantity(pendingService.getServiceQuantity());
                    mBookingDetail1.setServicePrice(pendingService.getServicePrice());
                    mBookingDetail1.setStatus(pendingService.getStatus());

                    if (mBookingDT1BLL.getBookingDetail_1(bookingID, mBookingDetail1.getServiceID()) > 0) {
                        mBookingDT1BLL.updateBookingDetail_1(mBookingDetail1);
                    } else {
                        mBookingDT1BLL.addNewBookingDetail_1(mBookingDetail1);
                    }
                }
            }
            if (!listServiceRemove.isEmpty()) {
                for (int serviceID : listServiceRemove) {
                    if (bookingID != -1 && mBookingDT1BLL.getBookingDetail_1(bookingID, serviceID) > 0) {
                        mBookingDT1BLL.deleteBookingDetail_1(bookingID, serviceID);
                    }
                }
            }

            //Update SERVICE
            if (!listServiceAvailable.isEmpty()) {
                for (Service service : listServiceAvailable) {
                    mServiceBLL.updateService(service.getServiceID(), service.getServiceQuantity(), service.getStatus());
                }
            }

            // release all list
            listRoomPending.clear();
            listRoomRemove.clear();
            listServicePending.clear();
            listServiceRemove.clear();
            listServiceAvailable.clear();

            this.dispose();
            ReceptionistForm.loadData();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRoomDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoomDetailActionPerformed
        selectedRow = tblRoomDetail.getSelectedRow();

        if (selectedRow == -1 || tblRoomDetail.getValueAt(selectedRow, 6) == null) {
            JOptionPane.showMessageDialog(this, "Select room to update!!", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String status = tblRoomDetail.getValueAt(selectedRow, 6).toString();
            if (status.equals("Returned")) {
                JOptionPane.showMessageDialog(this, "Already checked-out!! Can't modify", "warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int selectedRoomID = Integer.parseInt(tblRoomDetail.getValueAt(selectedRow, 0).toString());

                for (PendingRoom pendingRoom : listRoomPending) {
                    if (pendingRoom.getRoomID() == selectedRoomID) {
                        BookingRoomDetail bookingRoomDetail = new BookingRoomDetail(new javax.swing.JFrame("BookingRoom Detail"), true, bookingID, pendingRoom);
                        bookingRoomDetail.setTitle("Room detail");
                        bookingRoomDetail.setVisible(true);
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_btnRoomDetailActionPerformed

    private void btnCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckinActionPerformed
        selectedRow = tblRoomDetail.getSelectedRow();

        if (selectedRow == -1 || tblRoomDetail.getValueAt(selectedRow, 6) == null) {
            JOptionPane.showMessageDialog(this, "Select room to checkin!!", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String status = tblRoomDetail.getValueAt(selectedRow, 6).toString();

            if (!status.equals("Booked")) {
                JOptionPane.showMessageDialog(this, "Already checked-in", "warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int ask = JOptionPane.showConfirmDialog(this, "You checked room detail carefully before checkin?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (ask == JOptionPane.YES_OPTION) {
                    int roomID = Integer.parseInt(tblRoomDetail.getValueAt(selectedRow, 0).toString());
                    for (PendingRoom pendingRoom : listRoomPending) {
                        if (pendingRoom.getRoomID() == roomID) {
                            pendingRoom.setStatus(1);

                            JOptionPane.showMessageDialog(this, "Temporary saved! Press 'Save' button to save your change", "Notice", JOptionPane.INFORMATION_MESSAGE);
                            loadRoom();
                            break;
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnCheckinActionPerformed

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        selectedRow = tblRoomDetail.getSelectedRow();

        if (selectedRow == -1 || tblRoomDetail.getValueAt(selectedRow, 6) == null) {
            JOptionPane.showMessageDialog(this, "Select room to checkout!!", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String status = tblRoomDetail.getValueAt(selectedRow, 6).toString();

            if (status.equals("Booked")) {
                JOptionPane.showMessageDialog(this, "Not checked-in yet", "warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int roomID = Integer.parseInt(tblRoomDetail.getValueAt(selectedRow, 0).toString());
                // Check if this is last client of booking
                int checkin = 0;
                int notCheckin = 0;
                for (PendingRoom pendingRoom : listRoomPending) {
                    if (pendingRoom.getStatus() == 0) {
                        notCheckin += 1;
                    }

                    if (pendingRoom.getStatus() == 1) {
                        checkin += 1;
                    }
                }

                if (notCheckin > 0 && checkin == 1) {
                    JOptionPane.showMessageDialog(this, "                                Last client check-out. \nPlease check list room. There be room(s) not check-in yet!!", "warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    int ask = JOptionPane.showConfirmDialog(this, "You checked room detail carefully before checkin?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (ask == JOptionPane.YES_OPTION) {
                        for (PendingRoom pendingRoom : listRoomPending) {
                            if (pendingRoom.getRoomID() == roomID) {
                                pendingRoom.setStatus(2);

                                JOptionPane.showMessageDialog(this, "Temporary saved! Press 'Save' button to save your change", "Notice", JOptionPane.INFORMATION_MESSAGE);
                                loadRoom();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnCheckoutActionPerformed

    private void btnExportBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportBillActionPerformed
        if (mBooking.getStatus() == 0) {
            JOptionPane.showMessageDialog(this, "Not checkin yet!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mBooking.getStatus() == 2) {
            int ask = JOptionPane.showConfirmDialog(this, "Already checked-out! Do you want to view bill detail?", "Notification", JOptionPane.YES_NO_OPTION);
            if (ask == JOptionPane.YES_OPTION) {
                BillDialog billDialog = new BillDialog(new javax.swing.JFrame(), true, mUser, mBooking, mClient, listRoomPending, listServicePending);
                billDialog.setTitle("Bill form");
                billDialog.setVisible(true);
            }
        } else if (mBooking.getStatus() == 3) {
            JOptionPane.showMessageDialog(this, "This booking is canceled!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            BillDialog billDialog = new BillDialog(new javax.swing.JFrame(), true, mUser, mBooking, mClient, listRoomPending, listServicePending);
            billDialog.setTitle("Bill form");
            billDialog.setVisible(true);
        }
    }//GEN-LAST:event_btnExportBillActionPerformed

    private void btnReBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReBookingActionPerformed
        int ask = JOptionPane.showConfirmDialog(this, "This booking is canceled! Do you want to re-book it?", "Warning", JOptionPane.YES_NO_OPTION);
        if (ask == JOptionPane.YES_OPTION) {
            DateFormat mDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            boolean availableToReBooking = true;
            for (PendingRoom pendingRoom : listRoomPending) {
                Date checkinDate = pendingRoom.getCheckinTime();
                Date checkoutDate = pendingRoom.getCheckoutTime();
                String checkinString = mDateFormat.format(checkinDate);
                String checkoutString = mDateFormat.format(checkoutDate);
                if (!Room_Controller.availableToReBooking(bookingID, pendingRoom.getRoomID(), checkinString, checkoutString)) {
                    availableToReBooking = false;
                    break;
                }
            }

            if (availableToReBooking) {
                //UPdate status for BOOKING, BOOKING_DETAIL, BOOKING_DETAIL_1
                mBookingBLL.reBooking(bookingID);

                // Update list service (service unit = service unit - rebook service unit):
                ResultSet rs = mBookingDT1BLL.getBookingDetail_1_ByID(bookingID);
                try {
                    while (rs.next()) {
                        ResultSet rs1 = mServiceBLL.getServiceByName(rs.getString(3));
                        while (rs1.next()) {
                            if (rs1.getInt(4) - rs.getInt(4) > 0) {
                                mServiceBLL.updateService(rs1.getInt(1), rs1.getInt(4) - rs.getInt(4), 0);
                            } else {
                                mServiceBLL.updateService(rs1.getInt(1), rs1.getInt(4) - rs.getInt(4), 1);
                            }
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ReceptionistForm.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (PendingRoom pendingRoom : listRoomPending) {
                    pendingRoom.setStatus(0);
                }
                loadRoom();

                for (BookingDetail1 bookingDetail1 : listServicePending) {
                    for (Service service : listServiceAvailable) {
                        if (service.getServiceID() == bookingDetail1.getServiceID()) {
                            int current = service.getServiceQuantity();
                            int pending = bookingDetail1.getServiceQuantity();
                            service.setServiceQuantity(current - pending);
                            if (service.getServiceQuantity() <= 0) {
                                service.setStatus(1);
                            }
                        }
                    }
                }
                txtClientName.setEditable(true);
                txtClientPhone.setEditable(true);
                txtIDCard.setEditable(true);
                txtNote.setEditable(true);
                txtEstPrice.setEditable(true);

                btnAddRoom.setEnabled(true);
                btnRemoveRoom.setEnabled(true);
                btnRoomDetail.setEnabled(true);
                btnAddService.setEnabled(true);
                btnUpdateService.setEnabled(true);
                btnRemoveService.setEnabled(true);
                btnCreateBooking.setEnabled(true);
                btnSave.setEnabled(true);
                btnCheckin.setEnabled(true);
                btnCheckout.setEnabled(true);
                btnExportBill.setEnabled(true);
                btnReBooking.setEnabled(false);

                ReceptionistForm.loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Room list is not available for re-booking!! Please create new booking instead!", "warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnReBookingActionPerformed

    private void btnUpdateServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateServiceActionPerformed
        selectedRow = tblService.getSelectedRow();

        if (selectedRow == -1 || tblService.getValueAt(selectedRow, 0) == null) {
            JOptionPane.showMessageDialog(this, "Select serivce to update!!", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int serviceID = Integer.parseInt(tblService.getValueAt(selectedRow, 0).toString());
            for (BookingDetail1 pendingService : listServicePending) {
                if (pendingService.getServiceID() == serviceID) {
                    BookingServiceDetail bookingServiceDetail = new BookingServiceDetail(pendingService, new javax.swing.JFrame("Booking Service Detail"), true);
                    bookingServiceDetail.setTitle("Update booking service");
                    bookingServiceDetail.setVisible(true);
                    break;
                }
            }
        }
    }//GEN-LAST:event_btnUpdateServiceActionPerformed

    public static void loadRoom() {
        //Load data to table
        DefaultTableModel tblRoomDetailModel = (DefaultTableModel) tblRoomDetail.getModel();
        tblRoomDetailModel.setRowCount(0);
        DateFormat mDateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm");

        for (PendingRoom pendingRoom : listRoomPending) {
            String checkinString = mDateFormat.format(pendingRoom.getCheckinTime());
            String checkoutString = mDateFormat.format(pendingRoom.getCheckoutTime());

            String roomType;
            switch (pendingRoom.getRoomType()) {
                case 0:
                    roomType = "Single Room";
                    break;
                case 1:
                    roomType = "Couple Room";
                    break;
                default:
                    roomType = "Dormitory Room";
                    break;
            }

            String pdRoomStatus;
            switch (pendingRoom.getStatus()) {
                case 0:
                    pdRoomStatus = "Booked";
                    break;
                case 1:
                    pdRoomStatus = "Received";
                    break;
                case 2:
                    pdRoomStatus = "Returned";
                    break;
                default:
                    pdRoomStatus = "Canceled";
            }

            DecimalFormat df = new DecimalFormat("#.##");
            String[] data = {"" + pendingRoom.getRoomID(),
                "" + pendingRoom.getRoomNumber(),
                roomType, checkinString, checkoutString,
                df.format(pendingRoom.getTotalprice()), pdRoomStatus
            };

            tblRoomDetailModel.addRow(data);
        }
    }

    public static void loadService() {
        //Load data to table Service
        DefaultTableModel tblServiceModel = (DefaultTableModel) tblService.getModel();
        tblServiceModel.setRowCount(0);

        listServicePending.stream().map((pendingService) -> {
            int price = (int) (pendingService.getServicePrice() / pendingService.getServiceQuantity());
            String[] data = {
                "" + pendingService.getServiceID(),
                pendingService.getServiceName(),
                "" + price,
                "" + pendingService.getServiceQuantity(),
                "" + pendingService.getServicePrice()
            };
            return data;
        }).forEachOrdered((data) -> {
            tblServiceModel.addRow(data);
        });

        tblService.setModel(tblServiceModel);
    }

    private boolean checkInput() {
        String clientName = txtClientName.getText();
        String clientPhone = txtClientPhone.getText();
        String clientIDCard = txtIDCard.getText();

        if (clientName.equals("")) {
            JOptionPane.showMessageDialog(this, "Please input clientName", "Warning", JOptionPane.WARNING_MESSAGE);
            txtClientName.requestFocus();
            return false;
        } else if (clientPhone.equals("")) {
            JOptionPane.showMessageDialog(this, "Input client's phone number", "Warning", JOptionPane.WARNING_MESSAGE);
            txtClientPhone.requestFocus();
            return false;
        } else if (!ToolCheckInput.checkPhoneNumber(clientPhone)) {
            JOptionPane.showMessageDialog(this, "Phonge number format is not valid", "Warning", JOptionPane.WARNING_MESSAGE);
            txtClientPhone.requestFocus();
            return false;
        } else if (clientIDCard.equals("")) {
            JOptionPane.showMessageDialog(this, "Input client's ID card number", "Warning", JOptionPane.WARNING_MESSAGE);
            txtIDCard.requestFocus();
            return false;
        } else if (!ToolCheckInput.checkIDCard(clientIDCard)) {
            JOptionPane.showMessageDialog(this, "Invalid ID card number format", "Warning", JOptionPane.WARNING_MESSAGE);
            txtIDCard.requestFocus();
            return false;
        } else if (listRoomPending.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pleae add room(s) for booking!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRoom;
    private javax.swing.JButton btnAddService;
    private javax.swing.JButton btnCheckin;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnCreateBooking;
    private javax.swing.JButton btnExportBill;
    private javax.swing.JButton btnReBooking;
    private javax.swing.JButton btnRemoveRoom;
    private javax.swing.JButton btnRemoveService;
    private javax.swing.JButton btnRoomDetail;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdateService;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private static javax.swing.JTable tblRoomDetail;
    private static javax.swing.JTable tblService;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JTextField txtClientPhone;
    public static javax.swing.JTextField txtEstPrice;
    private javax.swing.JTextField txtIDCard;
    private javax.swing.JTextArea txtNote;
    // End of variables declaration//GEN-END:variables
}
