package com.mycompany.fishstore;

import static com.mycompany.fishstore.Orders.formatDate;
import java.sql.Connection;
import java.sql.Date;
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
public class Inventory extends javax.swing.JFrame {

    /**
     * Creates new form Inventory
     */
    public Inventory() {
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
        String query = "SELECT * FROM Inventory";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Clear existing table data
            DefaultTableModel model = (DefaultTableModel) inventory_table.getModel();
            model.setRowCount(0);

            // Populate the table with data from the database
            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getInt("inventory_id"),
                     resultSet.getInt("fish_id"),  
                    resultSet.getInt("qnt"),                
                    resultSet.getDate("last_updated")
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

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventory_table = new javax.swing.JTable();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        txt_inventory_id = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        txt_fish_id = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        txt_qnt = new javax.swing.JTextField();
        javax.swing.JLabel txt_last_up = new javax.swing.JLabel();
        txt_lastup = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_restore = new javax.swing.JButton();
        btn_backup = new javax.swing.JButton();
        btn_delete_all = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btn_clear = new javax.swing.JButton();
        btn_edit1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inventory List");
        jLabel1.setToolTipText("");

        inventory_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Inventory ID", "Fish_id", "Quantity", "Last Update"
            }
        ));
        jScrollPane1.setViewportView(inventory_table);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inventory ID");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fish ID");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantity");

        txt_last_up.setForeground(new java.awt.Color(255, 255, 255));
        txt_last_up.setText("Last Update");

        txt_lastup.setToolTipText("");

        btn_add.setBackground(new java.awt.Color(0, 51, 51));
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(102, 0, 0));
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_restore.setBackground(new java.awt.Color(102, 102, 0));
        btn_restore.setForeground(new java.awt.Color(255, 255, 255));
        btn_restore.setText("Restore");
        btn_restore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restoreActionPerformed(evt);
            }
        });

        btn_backup.setBackground(new java.awt.Color(204, 102, 0));
        btn_backup.setForeground(new java.awt.Color(255, 255, 255));
        btn_backup.setText("Backup");
        btn_backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backupActionPerformed(evt);
            }
        });

        btn_delete_all.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete_all.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete_all.setText("Delete All");
        btn_delete_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_allActionPerformed(evt);
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

        btn_edit1.setBackground(new java.awt.Color(0, 153, 255));
        btn_edit1.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit1.setText("Edit");
        btn_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(txt_qnt, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                            .addComponent(txt_inventory_id))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_lastup, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_fish_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_last_up, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btn_restore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btn_backup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn_edit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btn_delete_all)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_inventory_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fish_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_last_up))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_qnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_lastup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_add)
                                    .addComponent(btn_delete)
                                    .addComponent(btn_edit1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_restore))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_backup)
                                .addComponent(btn_clear)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete_all, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        // Clear the text fields
        txt_inventory_id.setText("");
        txt_fish_id.setText("");
        txt_lastup.setText("");
        txt_qnt.setText("");
        listAll(); // Display the table data on startup
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit1ActionPerformed
        // TODO add your handling code here:
        try {
            int item = Integer.parseInt(txt_inventory_id.getText());
            int fid = Integer.parseInt(txt_fish_id.getText());
            int qnt = Integer.parseInt(txt_qnt.getText());
            Date date = formatDate("12/01/2021");

            // Create a connection to the database
            String url = "jdbc:mysql://localhost:3306/my_fish_store";
            String username = "root";
            String password = "22703380";
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Connected to the database!");

                // Add the fish to the database
                FishStore.Inventory_item.edit_Inventory_Item(item, fid, qnt, date, connection);

            } catch (SQLException ex) {
                System.err.println("Database connection error: " + ex.getMessage());
                ex.printStackTrace();
            }
        } catch (NumberFormatException ex) {
            System.err.println("Error: Invalid fish ID or price format.");
        }
        txt_inventory_id.setText("");
        txt_fish_id.setText("");
        txt_qnt.setText("");
        txt_lastup.setText("");
        listAll();
    }//GEN-LAST:event_btn_edit1ActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        try {
            int item = Integer.parseInt(txt_inventory_id.getText());
            int fid = Integer.parseInt(txt_fish_id.getText());
            int qnt = Integer.parseInt(txt_qnt.getText());
            Date date = formatDate("12/01/2021");

            // Create a connection to the database
            String url = "jdbc:mysql://localhost:3306/my_fish_store";
            String username = "root";
            String password = "22703380";
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Connected to the database!");

                // Add the fish to the database
                FishStore.Inventory_item.add_Inventory_Item(item, fid, qnt, date, connection);

            } catch (SQLException ex) {
                System.err.println("Database connection error: " + ex.getMessage());
                ex.printStackTrace();
            }
        } catch (NumberFormatException ex) {
            System.err.println("Error: Invalid fish ID or price format.");
        }
        txt_inventory_id.setText("");
        txt_fish_id.setText("");
        txt_qnt.setText("");
        txt_lastup.setText("");
        listAll();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        int row = inventory_table.getSelectedRow(); // Get the selected row index
        if (row >= 0) { // Ensure a valid row is selected
            // Retrieve the primary key (fish_id) of the selected row
            DefaultTableModel model = (DefaultTableModel) inventory_table.getModel();
            int id = (int) model.getValueAt(row, 0); // Assuming 'fish_id' is the first column (index 0)

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
                    FishStore.Inventory_item.deleteItem(id, connection);
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
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_delete_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_allActionPerformed
        // TODO add your handling code here:
       String url = "jdbc:mysql://localhost:3306/my_fish_store";
        String username = "root";
        String password = "22703380";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Add the fish to the database
            FishStore.Inventory_item.delete_all_Items(connection);
        } catch (SQLException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
        listAll(); // Display the table data on startup
    }//GEN-LAST:event_btn_delete_allActionPerformed

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed
        // TODO add your handling code here:
          String url = "jdbc:mysql://localhost:3306/my_fish_store";
        String username = "root";
        String password = "22703380";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Add the fish to the database
            FishStore.Inventory_item.restore_Inventory(connection);
        } catch (SQLException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
        listAll(); // Display the table data on startup
    }//GEN-LAST:event_btn_restoreActionPerformed

    private void btn_backupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backupActionPerformed
        // TODO add your handling code here:
          String url = "jdbc:mysql://localhost:3306/my_fish_store";
        String username = "root";
        String password = "22703380";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Add the fish to the database
            FishStore.Inventory_item.backup_Inventory(connection);
        } catch (SQLException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
        listAll(); // Display the table data on startup
    }//GEN-LAST:event_btn_backupActionPerformed

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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_backup;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_delete_all;
    private javax.swing.JButton btn_edit1;
    private javax.swing.JButton btn_restore;
    private javax.swing.JTable inventory_table;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txt_fish_id;
    private javax.swing.JTextField txt_inventory_id;
    private javax.swing.JTextField txt_lastup;
    private javax.swing.JTextField txt_qnt;
    // End of variables declaration//GEN-END:variables
}
