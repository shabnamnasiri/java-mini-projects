package com.mycompany.fishstore;

import com.mycompany.fishstore.FishStore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class Customer extends javax.swing.JFrame {

    /**
     * Creates new form Customer
     */
    public Customer() {
        initComponents();
        listAll();
    }
private void listAll() {
    // Database connection parameters
    String url = "jdbc:mysql://localhost:3306/my_fish_store";
    String username = "root";
    String password = "22703380";

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        System.out.println("Connected to the database!");

        // Query to fetch all fish data
        String query = "SELECT * FROM Customer";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Clear existing table data
            DefaultTableModel model = (DefaultTableModel) customer_table.getModel();
            model.setRowCount(0);

            // Populate the table with data from the database
            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getInt("customer_id"),
                    resultSet.getString("fname"),
                    resultSet.getString("lname"),
                    resultSet.getString("phone"),
                };
                model.addRow(row);
            }
        }
    } catch (SQLException ex) {
        System.err.println("Database connection error: " + ex.getMessage());
        ex.printStackTrace();
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel4 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel13 = new javax.swing.JLabel();
        txt_fish_id2 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel14 = new javax.swing.JLabel();
        txt_name2 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel15 = new javax.swing.JLabel();
        txt_category2 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel16 = new javax.swing.JLabel();
        txt_price2 = new javax.swing.JTextField();
        btn_add2 = new javax.swing.JButton();
        btn_delete_all2 = new javax.swing.JButton();
        btn_backup2 = new javax.swing.JButton();
        btn_restore2 = new javax.swing.JButton();
        btn_delete2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customer_table = new javax.swing.JTable();
        txt_c_phone = new javax.swing.JTextField();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel17 = new javax.swing.JLabel();
        txt_customer_id = new javax.swing.JTextField();
        javax.swing.JLabel jLabel18 = new javax.swing.JLabel();
        txt_c_name = new javax.swing.JTextField();
        javax.swing.JLabel surname = new javax.swing.JLabel();
        txt_c_surname = new javax.swing.JTextField();
        btn_add_c = new javax.swing.JButton();
        btn_delete_c = new javax.swing.JButton();
        btn_restore_c = new javax.swing.JButton();
        btn_backup_c = new javax.swing.JButton();
        btn_delete_all_c = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        btn_clear = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Fish ID");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Name");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Category");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Price");
        jLabel16.setToolTipText("");

        btn_add2.setBackground(new java.awt.Color(0, 51, 51));
        btn_add2.setForeground(new java.awt.Color(255, 255, 255));
        btn_add2.setText("Add");

        btn_delete_all2.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete_all2.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete_all2.setText("Delete All");

        btn_backup2.setBackground(new java.awt.Color(204, 102, 0));
        btn_backup2.setForeground(new java.awt.Color(255, 255, 255));
        btn_backup2.setText("Backup");

        btn_restore2.setBackground(new java.awt.Color(102, 102, 0));
        btn_restore2.setForeground(new java.awt.Color(255, 255, 255));
        btn_restore2.setText("Restore");

        btn_delete2.setBackground(new java.awt.Color(102, 0, 0));
        btn_delete2.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete2.setText("Delete");

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_fish_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_category2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(220, 220, 220))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(241, 241, 241))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_name2)
                            .addComponent(btn_add2)
                            .addComponent(btn_restore2, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_backup2)
                                    .addComponent(btn_delete2))
                                .addGap(223, 223, 223))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txt_price2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jSeparator3)
                        .addGap(223, 223, 223))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btn_delete_all2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_fish_id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_category2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_name2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_price2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add2)
                    .addComponent(btn_delete2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_restore2)
                    .addComponent(btn_backup2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_delete_all2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer List");
        jLabel1.setToolTipText("");

        customer_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CID", "Name", "Surname", "Phone"
            }
        ));
        jScrollPane1.setViewportView(customer_table);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Phone");
        jLabel12.setToolTipText("");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Customer ID");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Name");

        surname.setForeground(new java.awt.Color(255, 255, 255));
        surname.setText("Surname");
        surname.setToolTipText("");

        btn_add_c.setBackground(new java.awt.Color(0, 51, 51));
        btn_add_c.setForeground(new java.awt.Color(255, 255, 255));
        btn_add_c.setText("Add");
        btn_add_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_cActionPerformed(evt);
            }
        });

        btn_delete_c.setBackground(new java.awt.Color(102, 0, 0));
        btn_delete_c.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete_c.setText("Delete");
        btn_delete_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_cActionPerformed(evt);
            }
        });

        btn_restore_c.setBackground(new java.awt.Color(102, 102, 0));
        btn_restore_c.setForeground(new java.awt.Color(255, 255, 255));
        btn_restore_c.setText("Restore");
        btn_restore_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restore_cActionPerformed(evt);
            }
        });

        btn_backup_c.setBackground(new java.awt.Color(204, 102, 0));
        btn_backup_c.setForeground(new java.awt.Color(255, 255, 255));
        btn_backup_c.setText("Backup");
        btn_backup_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backup_cActionPerformed(evt);
            }
        });

        btn_delete_all_c.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete_all_c.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete_all_c.setText("Delete All");
        btn_delete_all_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_all_cActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(0, 0, 153));
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(0, 153, 255));
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btn_restore_c, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                            .addComponent(btn_add_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_delete_c)
                                            .addComponent(btn_backup_c, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_edit)
                                            .addComponent(btn_clear)))
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(btn_delete_all_c)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_c_surname)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(txt_c_phone)
                            .addComponent(txt_customer_id)
                            .addComponent(jLabel17)
                            .addComponent(jLabel12))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(surname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_c_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_c_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_c_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_delete_c)
                                    .addComponent(btn_add_c))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_backup_c)
                                    .addComponent(btn_restore_c)
                                    .addComponent(btn_edit)))
                            .addComponent(btn_clear))
                        .addGap(19, 19, 19)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete_all_c, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_cActionPerformed
        // TODO add your handling code here:
        String name = txt_c_name.getText();
    String surname = txt_c_surname.getText();
     String phone = txt_c_phone.getText();   
    try {
        int customer_id = Integer.parseInt(txt_customer_id.getText());

        // Create a connection to the database
        String url = "jdbc:mysql://localhost:3306/my_fish_store";
        String username = "root";
        String password = "22703380";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Add the fish to the database
            FishStore.Customer.addCustomer(connection, customer_id, name, surname, phone);
            
        } catch (SQLException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
    } catch (NumberFormatException ex) {
        System.err.println("Error: Invalid Customer ID ");
    }

    // Clear the text fields
    txt_c_name.setText("");
    txt_c_surname.setText("");
    txt_c_phone.setText("");
    txt_customer_id.setText("");
    listAll(); // Display the table da
    }//GEN-LAST:event_btn_add_cActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        // Clear the text fields
        txt_c_name.setText("");
        txt_c_surname.setText("");
        txt_c_phone.setText("");
        txt_customer_id.setText("");
        listAll(); // Display the table data on startup
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
       String name = txt_c_name.getText();
    String surname = txt_c_surname.getText();
     String phone = txt_c_phone.getText();   
    try {
        int customer_id = Integer.parseInt(txt_customer_id.getText());

            // Create a connection to the database
            String url = "jdbc:mysql://localhost:3306/my_fish_store";
            String username = "root";
            String password = "22703380";
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Connected to the database!");

                // Add the fish to the database
                FishStore.Customer.editCustomer(connection, customer_id, name, surname, phone);

            } catch (SQLException ex) {
                System.err.println("Database connection error: " + ex.getMessage());
                ex.printStackTrace();
            }
        } catch (NumberFormatException ex) {
            System.err.println("Error: Invalid fish ID or price format.");
        }

        // Clear the text fields
        txt_c_name.setText("");
        txt_c_surname.setText("");
        txt_c_phone.setText("");
        txt_customer_id.setText("");
        listAll(); // Display the table data on startup

    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_delete_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_cActionPerformed
        // TODO add your handling code here:
         int row = customer_table.getSelectedRow(); // Get the selected row index
    if (row >= 0) { // Ensure a valid row is selected
        // Retrieve the primary key (fish_id) of the selected row
        DefaultTableModel model = (DefaultTableModel) customer_table.getModel();
        int cid = (int) model.getValueAt(row, 0); // Assuming 'fish_id' is the first column (index 0)

        // Confirm with the user before deletion
        int confirmation = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete this record?",
                "Delete Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            String url = "jdbc:mysql://localhost:3306/my_fish_store";
            String username = "root";
            String password = "22703380";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Connected to the database!");

                // Use the fish_id to delete the correct record
                FishStore.Customer.deleteCustomer(connection, cid);
                // Refresh the table
                listAll();
            } catch (SQLException ex) {
                System.err.println("Database connection error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    } else {
        // Display a message if no row is selected
        JOptionPane.showMessageDialog(null, "Please select a row to delete.");
    }

                                             
    }//GEN-LAST:event_btn_delete_cActionPerformed

    private void btn_delete_all_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_all_cActionPerformed
        // TODO add your handling code here:
         String url = "jdbc:mysql://localhost:3306/my_fish_store";
        String username = "root";
        String password = "22703380";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Add the fish to the database
            FishStore.Customer.delete_all_customers(connection);
        } catch (SQLException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
            listAll(); // Display the table data on startup
    }//GEN-LAST:event_btn_delete_all_cActionPerformed

    private void btn_backup_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backup_cActionPerformed
        // TODO add your handling code here:
        String url = "jdbc:mysql://localhost:3306/my_fish_store";
        String username = "root";
        String password = "22703380";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Add the fish to the database
            FishStore.Customer.backup_customer(connection);
        } catch (SQLException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
                    listAll(); // Display the table data on startup
    }//GEN-LAST:event_btn_backup_cActionPerformed

    private void btn_restore_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restore_cActionPerformed
        // TODO add your handling code here:
                String url = "jdbc:mysql://localhost:3306/my_fish_store";
        String username = "root";
        String password = "22703380";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Add the fish to the database
            FishStore.Customer.restore_customer(connection);
        } catch (SQLException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
                    listAll(); // Display the table data on startup
    }//GEN-LAST:event_btn_restore_cActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add2;
    private javax.swing.JButton btn_add_c;
    private javax.swing.JButton btn_backup2;
    private javax.swing.JButton btn_backup_c;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete2;
    private javax.swing.JButton btn_delete_all2;
    private javax.swing.JButton btn_delete_all_c;
    private javax.swing.JButton btn_delete_c;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_restore2;
    private javax.swing.JButton btn_restore_c;
    private javax.swing.JTable customer_table;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField txt_c_name;
    private javax.swing.JTextField txt_c_phone;
    private javax.swing.JTextField txt_c_surname;
    private javax.swing.JTextField txt_category2;
    private javax.swing.JTextField txt_customer_id;
    private javax.swing.JTextField txt_fish_id2;
    private javax.swing.JTextField txt_name2;
    private javax.swing.JTextField txt_price2;
    // End of variables declaration//GEN-END:variables
}
