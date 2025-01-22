/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package com.mycompany.fishstore;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
/**
 *
 * @author Lenovo
 */
public class FishStore{
    
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_fish_store";
        String username = "root";
        String password = "22703380";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            //add all data
            Fish.delete_all_fishes(connection);
            Fish.addFish(connection,1,"Goldfish", "Freshwater", 10.5f);
            Fish.addFish(connection,2,"Salmon", "Saltwater", 25.0f);
            Fish.addFish(connection,3,"Catfish", "Freshwater", 15.0f);
            Fish.addFish(connection,4,"Tuna", "Saltwater", 35.0f);
            Fish.addFish(connection,5,"Betta", "Freshwater", 8.0f);
            
           Customer.delete_all_customers(connection);
           Customer.addCustomer(connection,101, "John", "Doe", "1234567890");
           Customer.addCustomer(connection,102, "Jane", "Smith", "9876543210");
           Customer.addCustomer(connection, 103,"Alice", "Brown", "1112223333");
           Customer.addCustomer(connection, 104,"Bob", "Taylor", "4445556666");
           Customer.addCustomer(connection, 105,"Charlie", "Davis", "7778889990");
//            
           Order.deleteAllOrders(connection);
           Date orderDate1 = formatDate("12/01/2021");
           Order.addOrder(201,101, 50, orderDate1, "Credit card", connection);
           
            Date orderDate2 = formatDate("12/03/2021");
           Order.addOrder(202,102, 75, orderDate2, "Cash", connection);
           
           Date orderDate3 = formatDate("12/05/2021");
           Order.addOrder(203, 103,120, orderDate3, "Debit card", connection);

           Date orderDate4 = formatDate("12/07/2021");
           Order.addOrder(204,104, 90, orderDate4, "Cash", connection);

           Date orderDate5 = formatDate("12/08/2021");
           Order.addOrder(205,105, 200, orderDate5, "Credit card", connection);
//           
//           
//           Inventory_item.delete_all_Items(connection);
           LocalDate currentDate = LocalDate.now();
           Date sqlDate = Date.valueOf(currentDate); 
           Inventory_item.add_Inventory_Item(401,1, 50, sqlDate, connection);
           Inventory_item.add_Inventory_Item(402,2, 30, sqlDate, connection);
           Inventory_item.add_Inventory_Item(403,3, 20, sqlDate, connection);
           Inventory_item.add_Inventory_Item(404,4, 15, sqlDate, connection);
           Inventory_item.add_Inventory_Item(405,5, 25, sqlDate, connection);
//           
//           

           Order_detail.addRow(301,201, 1, 2, 21, connection);
           Order_detail.addRow(302,201, 3, 2, 30, connection);
//
           Order_detail.addRow(303,202, 2, 2, 50, connection);
           Order_detail.addRow(304,202, 5, 3, 24, connection);           
//           
           Order_detail.addRow(305,203, 3, 5, 75, connection);
           Order_detail.addRow(306,203, 4, 2, 70, connection);
           Order_detail.addRow(307,203, 5, 2, 16, connection);
//
           Order_detail.addRow(308,204,1, 3, 31, connection);
           Order_detail.addRow(309,204, 4, 2, 70, connection);
//
           Order_detail.addRow(310, 205,2, 4, 100, connection);
           Order_detail.addRow(311, 205,5, 5, 40, connection);
           Order_detail.addRow(312,205, 12, 3, 30, connection);   

           
           //list all data
            Fish.list_all_fishes(connection);
            Customer.list_all_customers(connection);
            Order.list_all_orders(connection);
            Inventory_item.list_all_inventory_items(connection);
            Order_detail.list_all_rows(connection);
  
            
            //edit the second obj
            Fish.editFish(connection, 2, "Salmon", "Freshwater", 27.0f);
            Customer.editCustomer(connection, 102, "Jane", "Smith", "55555555");
           Order.editOrder(connection, 202, 102, 75,orderDate2,"Mobile Wallet");
            Inventory_item.edit_Inventory_Item(402, 2, 35, sqlDate, connection);
           Order_detail.editOrder_detail(connection, 302, 201, 3, 4, 32);
           
             //list all data
            Fish.list_all_fishes(connection);
            Customer.list_all_customers(connection);
            Order.list_all_orders(connection);
            Inventory_item.list_all_inventory_items(connection);
            Order_detail.list_all_rows(connection);

            //backup
           Fish.backupFishes(connection);
            Customer.backup_customer(connection);
           Order.backup_order(connection);
            Inventory_item.backup_Inventory(connection);
            Order_detail.backup_row(connection);
            
            
            //deleteing 3rd obj
            Inventory_item.deleteItem(403, connection);
            Order_detail.delete_row(303, connection);        
             Order.delete_order(203, connection);
            Fish.deleteFish(connection, 3);
            Customer.deleteCustomer(connection, 103);  

              //list all data
            Fish.list_all_fishes(connection);
            Customer.list_all_customers(connection);
            Order.list_all_orders(connection);
            Inventory_item.list_all_inventory_items(connection);
            Order_detail.list_all_rows(connection);

            
             //restore
            Fish.restore_fishes(connection);
            Customer.restore_customer(connection);
            Order.restore_order(connection);
            Inventory_item.restore_Inventory(connection);
            Order_detail.restore_row(connection);

            //list all data
            Fish.list_all_fishes(connection);
            Customer.list_all_customers(connection);
            Order.list_all_orders(connection);
            Inventory_item.list_all_inventory_items(connection);
            Order_detail.list_all_rows(connection);


           

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Date formatDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date parsedDate = dateFormat.parse(date);
            return new Date(parsedDate.getTime()); // Convert java.util.Date to java.sql.Date
        } catch (ParseException e) {
            System.err.println("Error parsing date: " + date);
            e.printStackTrace();
            return null; // Consider throwing an exception instead of returning null
        }
    }
    public class Fish{
        int fish_id;
        String fish_name;
        String fish_category;
        float fish_price;
        
        public  void setFish_id(int id){
            this.fish_id = id;
        }
        public  void setFish_name(String name){
            this.fish_name = name;
        }
        public  void setFish_category(String category){
            this.fish_category = category;
        }
        public  void setFish_price(float price){
            this.fish_price = price;
        }
        public int getFish_id(){
            return this.fish_id;
        }
        public String getFish_name(){
            return this.fish_name ;
        }
        public String getFish_category(){
            return this.fish_category ;
        }
        public float getFish_price(){
            return this.fish_price ;
        }
        
   
    public static boolean checkFish(Connection connection, int fish_id) {
        String checkQuery = "SELECT COUNT(*) FROM fish WHERE fish_ID= ?";
        try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
            statement.setInt(1, fish_id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() && resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void addFish(Connection connection,int fish_id, String fish_name, String fish_category,
            float fish_price) {
        String query = "INSERT IGNORE  INTO fish ( fish_id,fish_name, fish_category, fish_price) VALUES (?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, fish_id);            
            statement.setString(2, fish_name);
            statement.setString(3, fish_category);
            statement.setFloat(4, fish_price);
            if(!checkFish(connection,fish_id)){                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.printf("\nFish id : %d added successfully!",fish_id);
                }
            }
            else{
                System.out.printf("\nFish id : %d  is already in the table!",fish_id);
            }
        } 
        catch (SQLException e) {
             System.err.println("Error occurred while adding fish with name: " +fish_name+ e.getMessage());
            e.printStackTrace();
        }
    }
       public static boolean checkfidb(Connection connection, int fish_id){
         String checkQuery = "SELECT COUNT(*) FROM fish_backup WHERE fish_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
            statement.setInt(1, fish_id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() && resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void editFish(Connection connection, int fish_id,String fish_name, String fish_category,
            float fish_price) {
        String query = "Update fish SET fish_name= ? , fish_category = ? , fish_price = ? WHERE fish_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {            
            statement.setString(1, fish_name);
            statement.setString(2, fish_category);
            statement.setFloat(3, fish_price);
            statement.setInt(4, fish_id);
            if(checkFish(connection,fish_id)){                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Fish Edited successfully!");
                }
            }
            else{
                   System.out.println("Fish_id not found!");
            }
        } 
        catch (SQLException e) {
             System.err.println("Error occurred while editing fish with id: " +fish_id +e.getMessage());
            e.printStackTrace();
        }
    }
    public static void deleteFish(Connection connection , int fish_id){
        
        String query = "Delete from fish WHERE fish_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {            
            statement.setInt(1, fish_id);
            if(checkFish(connection,fish_id)){                
                int rowsDeleted  = statement.executeUpdate();
                if (rowsDeleted  > 0) {
                    System.out.println("\nFish deleted successfully!");
                }
            }
            else{
                   System.out.println("Fish id not found!");
            }
        } 
        catch (SQLException e) {
           System.err.println("Error occurred while deleting fish with id: " +fish_id+ e.getMessage());
            e.printStackTrace();
        }
        
    }
    public static void delete_all_fishes(Connection connection){
                String query = "Delete from fish ";
        try (PreparedStatement statement = connection.prepareStatement(query)) {                  
                int rowsDeleted  = statement.executeUpdate();
                if (rowsDeleted  > 0) {
                    System.out.printf("\n%d Fish deleted successfully!",rowsDeleted);
                }
               
        } 
        catch (SQLException e) {
           System.err.println("Error occurred while deleting all fishes : "+ e.getMessage());
            e.printStackTrace();
        }

    }
    public static void listFish(Connection connection , int fish_id){
        String query = "SELECT * from  fish WHERE fish_id = ?";
         try(PreparedStatement pstmt = connection.prepareStatement(query)){ 
                    pstmt.setInt(1, fish_id); 
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                    System.out.println("\nFish ID: " + rs.getInt("fish_id"));
                    System.out.println("Fish Name: " + rs.getString("fish_name"));
                    System.out.println("Fish Category: " + rs.getString("fish_category"));
                    System.out.println("Fish Price: " + rs.getFloat("fish_price"));
                    System.out.println("-----------------------");
                    } 
                    else {
                     System.out.println("Fish with ID " + fish_id + " does not exist.");
                     System.out.println("-----------------------");
                    }
                    rs.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing fish: " + e.getMessage());
                }
          
    }
    public static void list_all_fishes(Connection connection){
                    String query = "SELECT * from  fish";
         try(PreparedStatement pstmt = connection.prepareStatement(query)){ 
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                    System.out.println("Fish ID: " + rs.getInt("fish_id"));
                    System.out.println("Fish Name: " + rs.getString("fish_name"));
                    System.out.println("Fish Category: " + rs.getString("fish_category"));
                    System.out.println("Fish Price: " + rs.getFloat("fish_price"));
                    System.out.println("-----------------------");
                    } 
                    rs.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing fish: " + e.getMessage());
                }

    }
    public static void backupFishes(Connection connection) {
    String selectFish = "SELECT * FROM fish";
    String insertBackup = "INSERT INTO fish_backup (fish_id, fish_name, fish_category, fish_price) VALUES (?, ?, ?, ?)";

    try (PreparedStatement selectStmt = connection.prepareStatement(selectFish);
         ResultSet rs = selectStmt.executeQuery();
         PreparedStatement insertStmt = connection.prepareStatement(insertBackup)) {

        while (rs.next()) {
            
            int fishId = rs.getInt("fish_id");
            String fishName = rs.getString("fish_name");
            String fishCategory = rs.getString("fish_category");
            float fishPrice = rs.getFloat("fish_price");
            if(!checkfidb(connection , fishId)){
            insertStmt.setInt(1, fishId);
            insertStmt.setString(2, fishName);
            insertStmt.setString(3, fishCategory);
            insertStmt.setFloat(4, fishPrice);


            int rowsInserted = insertStmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Fish with ID " + fishId + " backed up successfully.");
            } else {
                System.out.println("Error");
            }
        }
            else{
                 System.out.println("Fish with ID " + fishId + " already exists in the backup.");
            }
        }
    } catch (SQLException e) {
        System.err.println("Error while backing up fish data: " + e.getMessage());
        e.printStackTrace();
    }
}
    public static void restore_fishes(Connection connection){
        String selectFish = "SELECT * FROM fish_backup";
    String restore = "INSERT INTO fish (fish_id, fish_name, fish_category, fish_price) "
                        + "SELECT ?, ?, ?, ? "
                        + "WHERE NOT EXISTS (SELECT 1 FROM fish WHERE fish_id = ?)";

    try (PreparedStatement selectStmt = connection.prepareStatement(selectFish);
         ResultSet rs = selectStmt.executeQuery();
         PreparedStatement insertStmt = connection.prepareStatement(restore)) {

        while (rs.next()) {
            int fishId = rs.getInt("fish_id");
            String fishName = rs.getString("fish_name");
            String fishCategory = rs.getString("fish_category");
            float fishPrice = rs.getFloat("fish_price");
            if(!checkFish(connection , fishId)){
            insertStmt.setInt(1, fishId);
            insertStmt.setString(2, fishName);
            insertStmt.setString(3, fishCategory);
            insertStmt.setFloat(4, fishPrice);
            insertStmt.setInt(5, fishId); 

            int rowsInserted = insertStmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Fish with ID " + fishId + " restored successfully.");
            } else {
                System.out.println("Fish with ID " + fishId + " already exists in the fish.");
            }
        }}
    } catch (SQLException e) {
        System.err.println("Error while backing up fish data: " + e.getMessage());
        e.printStackTrace();
    }
    }
    
}
    public class Customer{
        int customer_id;
        String customer_fname;
        String customer_lname;
        String customer_phone;

        public void setCustomer_id(int cid){
            this.customer_id = cid;
    }
        public void setCustomer_fname(String fname){
            this.customer_fname = fname;
        }
        public void setCustomer_lname(String lname){
            this.customer_lname = lname;
        }
        public void setCustomer_phone(String phone){
            this.customer_phone= phone;
        }
        public int getCustomer_id(){
            return this.customer_id;
        }
        public String getCustomer_fname(){
            return this.customer_fname;
        }
        public String getCustomer_lname(){
            return this.customer_lname;
        }
         public String getCustomer_phone(){
            return this.customer_phone;
        }
         public static boolean checkCustomer(Connection connection, int cid) {
        String checkQuery = "SELECT COUNT(*) FROM customer WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
            statement.setInt(1, cid);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() && resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
         public static void addCustomer(Connection connection ,int customer_id, String fname, String lname,String phone){ 
            String query = "INSERT IGNORE INTO customer ( customer_id,fname, lname, phone) VALUES ( ?,?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) { 
                statement.setInt(1, customer_id);
                statement.setString(2, fname);
                statement.setString(3, lname);
                statement.setString(4, phone);
                if(!checkCustomer(connection,customer_id)){                
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.printf("\nCustomer id: %d added successfully!",customer_id);
                    }
                }
                else{
                    System.out.printf("\nCustomer id: %d is already in the table!",customer_id);
                }
            } 
            catch (SQLException e) {
                 System.err.println("Error occurred while adding Customer with name: " +lname+ e.getMessage());
                e.printStackTrace();
            }

         
         }
         public static boolean checkcidbk(Connection connection, int cid){
         String checkQuery = "SELECT COUNT(*) FROM customer_backup WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
            statement.setInt(1, cid);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() && resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
         public static void editCustomer(Connection connection ,int customer_id, String fname, String lname
                 ,String phone) {
             String query = "Update customer SET fname= ? , lname = ? , phone = ? WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {            
            statement.setString(1, fname);
            statement.setString(2, lname);
            statement.setString(3, phone);
            statement.setInt(4, customer_id);
            
            if(checkCustomer(connection,customer_id)){                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Customer Edited successfully!");
                }
            }
            else{
                   System.out.println("customer id not found!");
            }
        } 
        catch (SQLException e) {
             System.err.println("Error occurred while editing customer with id: " +customer_id +e.getMessage());
            e.printStackTrace();
        }
         }   
         public static void deleteCustomer(Connection connection , int customer_id){
             String query = "Delete from customer WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {            
            statement.setInt(1, customer_id);
            if(checkCustomer(connection,customer_id)){                
                int rowsDeleted  = statement.executeUpdate();
                if (rowsDeleted  > 0) {
                    System.out.println("customer deleted successfully!");
                }
            }
            else{
                   System.out.println("customer id not found!");
            }
        } 
        catch (SQLException e) {
           System.err.println("Error occurred while deleting customer with id: " +customer_id+ e.getMessage());
            e.printStackTrace();
        }
        
         }
         public static void listCustomer(Connection connection , int customer_id){
             String query = "SELECT * from  customer WHERE customer_id = ?";
         try(PreparedStatement pstmt = connection.prepareStatement(query)){ 
                    pstmt.setInt(1, customer_id); 
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                    System.out.println("\nCustomer ID: " + rs.getInt("customer_id"));
                    System.out.println("Customer First Name: " + rs.getString("fname"));
                    System.out.println("Customer Last Name: " + rs.getString("lname"));
                    System.out.println("Customer Phone: " + rs.getString("phone"));
                    System.out.println("-----------------------");
                    } 
                    else {
                     System.out.println("customer with ID " + customer_id + " does not exist.");
                     System.out.println("-----------------------");
                    }
                    rs.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing customer: " + e.getMessage());
                }
         }
         public static void list_all_customers(Connection connection){
             String query = "SELECT * from  customer ";
         try(PreparedStatement pstmt = connection.prepareStatement(query)){ 
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                    System.out.println("\nCustomer ID: " + rs.getInt("customer_id"));
                    System.out.println("Customer First Name: " + rs.getString("fname"));
                    System.out.println("Customer Last Name: " + rs.getString("lname"));
                    System.out.println("Customer Phone: " + rs.getString("phone"));
                    System.out.println("-----------------------");
                    } 
                    rs.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing customer: " + e.getMessage());
                }
         }
         public static void delete_all_customers(Connection connection){
             String query = "Delete from customer ";
        try (PreparedStatement statement = connection.prepareStatement(query)) {                           
                int rowsDeleted  = statement.executeUpdate();
                if (rowsDeleted  > 0) {
                    System.out.println("customer deleted successfully!");
                }
            else{
                   System.out.println("customer_id not found!");
            }
        } 
        catch (SQLException e) {
           System.err.println("Error occurred while deleting customer "+ e.getMessage());
            e.printStackTrace();
        }
        
         }
         public static void backup_customer(Connection connection){
            String selectFish = "SELECT * FROM customer";
            String insertBackup = "INSERT INTO customer_backup (customer_id, fname, lname, phone) VALUES (?, ?, ?, ?)";

        try (PreparedStatement selectStmt = connection.prepareStatement(selectFish);
            ResultSet rs = selectStmt.executeQuery();
            PreparedStatement insertStmt = connection.prepareStatement(insertBackup)) {

           while (rs.next()) {

               int cid = rs.getInt("customer_id");
               String fname = rs.getString("fname");
               String lname = rs.getString("lname");
               String phone = rs.getString("phone");
               if(!checkcidbk(connection , cid)){
               insertStmt.setInt(1, cid);
               insertStmt.setString(2, fname);
               insertStmt.setString(3, lname);
               insertStmt.setString(4, phone);


               int rowsInserted = insertStmt.executeUpdate();
               if (rowsInserted > 0) {
                   System.out.println("customer with ID " + cid + " backed up successfully.");
               } else {
                System.out.println("Error");
            }
        }
            else{
                 System.out.println("customer with ID " + cid + " already exists in the backup.");
            }
           }
    } catch (SQLException e) {
        System.err.println("Error while backing up customer data: " + e.getMessage());
        e.printStackTrace();
    } 
         }
          public static void restore_customer(Connection connection){
              String selectFish = "SELECT * FROM customer_backup";
            String insertBackup = "INSERT INTO customer (customer_id, fname, lname, phone) VALUES (?, ?, ?, ?)";

        try (PreparedStatement selectStmt = connection.prepareStatement(selectFish);
            ResultSet rs = selectStmt.executeQuery();
            PreparedStatement insertStmt = connection.prepareStatement(insertBackup)) {

           while (rs.next()) {

               int cid = rs.getInt("customer_id");
               String fname = rs.getString("fname");
               String lname = rs.getString("lname");
               String phone = rs.getString("phone");
               if(!checkCustomer(connection , cid)){
               insertStmt.setInt(1, cid);
               insertStmt.setString(2, fname);
               insertStmt.setString(3, lname);
               insertStmt.setString(4, phone);


               int rowsInserted = insertStmt.executeUpdate();
               if (rowsInserted > 0) {
                   System.out.println("customer with ID " + cid + " restores up successfully.");
               } else {
                   System.out.println("customer with ID " + cid + " already exists in the table.");
               }
           }
           }
            } catch (SQLException e) {
                System.err.println("Error while restoring up customer data: " + e.getMessage());
                e.printStackTrace();
            } 
         }
         
}
    public class Order{
    int order_id;
    int customer_id;
    long total;
    String paymnet;
    Date purchase_date;
    
    public void setOrder_id(int oid){
        this.order_id = oid;
    }
    public void setCustomer_id(int cid){
        this.customer_id = cid;
    }
    public void setTotal(long total){
        this.total=total;
    }
    public void setPurchase_date(Date date){
        this.purchase_date=date;
    }
    public void setPayment(String payment){
        this.paymnet = payment;
    }
    public int getOrder_id(){
        return this.order_id;
    }
    public int getCustomer_id(){
        return this.customer_id;
    }
    public long getTotal(){
        return this.total;
    }
    public Date getPurchased_date(){
        return this.purchase_date;
    
    
    }
    public String getPayment(){
        return this.paymnet;
    }
    
    public static void addOrder(int order_id,int customer_id , long total , Date date ,String payment, Connection connection){
        String query = "INSERT IGNORE INTO orders ( order_id,customer_id, total, purchase_date,payment) VALUES (?, ?, ?, ?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) { 
                 statement.setInt(1, order_id);
                statement.setInt(2, customer_id);
                statement.setLong(3, total);
                statement.setDate(4, new java.sql.Date(date.getTime()));  
                statement.setString(5, payment);
                if(checkcid(connection,customer_id)){
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Order added successfully!");
                    }
                }

            } 
            catch (SQLException e) {
                 System.err.println("Error occurred while adding Order with customer id: " +customer_id+ ". " + e.getMessage());
                e.printStackTrace();
            }
    }
    public static boolean checkcid(Connection connection, int cid){
         String checkQuery = "SELECT COUNT(*) FROM customer WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
            statement.setInt(1, cid);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() && resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean checkoid(Connection connection, int oid){
         String checkQuery = "SELECT COUNT(*) FROM orders WHERE order_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
            statement.setInt(1, oid);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() && resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean checkoidbk(Connection connection, int oid){
         String checkQuery = "SELECT COUNT(*) FROM orders_backup WHERE order_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
            statement.setInt(1, oid);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() && resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void editOrder(Connection connection ,int order_id,int customer_id , long total 
            , Date date ,String payment) {
        String query = "Update orders SET customer_id= ? , total = ? ,purchase_date = ? ,payment = ?  "
                + "WHERE order_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {            
            statement.setInt(1, customer_id);
            statement.setLong(2, total);
            statement.setDate(3, new java.sql.Date(date.getTime()));
            statement.setString(4, payment);
            statement.setInt(5, order_id);
            
            if(checkcid(connection,customer_id) && checkoid(connection,order_id)){                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Order Edited successfully!");
                }
            }
            else{
                   System.out.println("customer_id or order_id not found!");
            }
        } 
        catch (SQLException e) {
             System.err.println("Error occurred while editing order with id: " +order_id +e.getMessage());
            e.printStackTrace();
        }
         }   
    public static void delete_order(int order_id , Connection connection){
         String query = "Delete from orders WHERE order_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {            
            statement.setInt(1, order_id);
            if(checkoid(connection,order_id)){                
                int rowsDeleted  = statement.executeUpdate();
                if (rowsDeleted  > 0) {
                    System.out.println("Order deleted successfully!");
                }
            }
            else{
                   System.out.println("order_id not found!");
            }
        } 
        catch (SQLException e) {
           System.err.println("Error occurred while deleting customer with id: " +order_id+ e.getMessage());
            e.printStackTrace();
        }
    }
    public static void deleteAllOrders(Connection connection) {
            String query = "DELETE FROM orders"; 

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("All orders deleted successfully!");
                } else {
                    System.out.println("No orders found to delete.");
                }
            } catch (SQLException e) {
                System.err.println("Error occurred while deleting orders: " + e.getMessage());
                e.printStackTrace();
            }
        }
    public static void listOrder(Connection connection , int order_id){
             String query = "SELECT * from  orders WHERE order_id = ?";
         try(PreparedStatement pstmt = connection.prepareStatement(query)){ 
                    pstmt.setInt(1, order_id); 
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                    System.out.println("\nOrder ID: " + rs.getInt("order_id"));
                    System.out.println("Customer ID: " +rs.getInt("customer_id"));
                    System.out.println("Total: " + rs.getLong("total"));
                    System.out.println("Purchase date: " + rs.getDate("purchase_date"));
                    System.out.println("Payment: " + rs.getString("payment"));
                    System.out.println("-----------------------");
                    } 
                    else {
                     System.out.println("Order with ID " + order_id + " does not exist.");
                     System.out.println("-----------------------");
                    }
                    rs.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing Order: " + e.getMessage());
                }
         }   
    public static void list_all_orders(Connection connection){
             String query = "SELECT * from  orders ";
         try(PreparedStatement pstmt = connection.prepareStatement(query)){ 
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                    System.out.println("\nOrder ID: " + rs.getInt("order_id"));
                    System.out.println("Customer ID: " +rs.getInt("customer_id"));
                    System.out.println("Total: " + rs.getLong("total"));
                    System.out.println("Purchase date: " + rs.getDate("purchase_date"));
                    System.out.println("Payment: " + rs.getString("payment"));
                    System.out.println("-----------------------");
                    } 
                    rs.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing Orders: " + e.getMessage());
                }
         }   
    public static void backup_order(Connection connection){
            String selectFish = "SELECT * FROM orders";
            String insertBackup = "INSERT INTO orders_backup (order_id,customer_id, total, purchase_date,payment) VALUES (?,?, ?, ?, ?)";

        try (PreparedStatement selectStmt = connection.prepareStatement(selectFish);
            ResultSet rs = selectStmt.executeQuery();
            PreparedStatement insertStmt = connection.prepareStatement(insertBackup)) {

           while (rs.next()) {

               int oid = rs.getInt("order_id");
               int cid = rs.getInt("customer_id");
               long total = rs.getLong("total");
               String payment = rs.getString("payment");
               Date date = rs.getDate("purchase_date");
               if(!checkoidbk(connection , oid)){
               insertStmt.setInt(1, oid);
               insertStmt.setInt(2, cid);
               insertStmt.setLong(3,total);
               insertStmt.setDate(4, new java.sql.Date(date.getTime()));
               insertStmt.setString(5,payment);

               int rowsInserted = insertStmt.executeUpdate();
               if (rowsInserted > 0) {
                   System.out.println("Order with ID " + oid + " backed up successfully.");
               } else {
                   System.out.println("Error.");
               }
           }
               else {
                   System.out.println("Order with ID " + oid + " already exists in the backup.");
               }
           }
        } catch (SQLException e) {
            System.err.println("Error while backing up Orders data: " + e.getMessage());
            e.printStackTrace();
        } 
             }
     public static void restore_order(Connection connection){
            String selectFish = "SELECT * FROM orders_backup";
            String insertBackup = "INSERT INTO orders (order_id,customer_id, total, purchase_date,payment) VALUES (?,?, ?, ?, ?)";

        try (PreparedStatement selectStmt = connection.prepareStatement(selectFish);
            ResultSet rs = selectStmt.executeQuery();
            PreparedStatement insertStmt = connection.prepareStatement(insertBackup)) {

           while (rs.next()) {

               int oid = rs.getInt("order_id");
               int cid = rs.getInt("customer_id");
               long total = rs.getLong("total");
               String payment = rs.getString("payment");
               Date date = rs.getDate("purchase_date");
               if(!checkoid(connection , oid)){
               insertStmt.setInt(1, oid);
               insertStmt.setInt(2, cid);
               insertStmt.setLong(3,total);
               insertStmt.setDate(4, new java.sql.Date(date.getTime()));
               insertStmt.setString(5,payment);

               int rowsInserted = insertStmt.executeUpdate();
               if (rowsInserted > 0) {
                   System.out.println("Order with ID " + oid + " restored successfully.");
               } else {
                   System.out.println("Order with ID " + oid + " already exists in the table.");
               }
           }
           }
        } catch (SQLException e) {
            System.err.println("Error while restoring Orders data: " + e.getMessage());
            e.printStackTrace();
        } 
             }
    }
    public class Inventory_item{
        int inventory_id;
        int fish_id;
        int quantity;
        Date last_updated;
        
        public  void setInventory_id(int inventory_id){
            this.inventory_id=inventory_id;
        }
        public void setFish_id(int fish_id){
            this.fish_id = fish_id;
        }
        public void setQuantity(int qnt){
            this.quantity=qnt;
        }
        public void setLast_updated(Date date){
            this.last_updated = date;
        }
        public int getInventory_id(){
            return this.inventory_id;
        }
        public int getFish_id(){
            return this.fish_id;
        }
        public int quantity(){
            return this.quantity;
        }
        public Date getLast_update(){
            return this.last_updated;
        }
        public static void add_Inventory_Item(int inventory_id,int fish_id, int qnt , Date last_update , Connection connection){
            String query = "INSERT IGNORE INTO inventory (inventory_id, fish_id, qnt, last_updated) VALUES ( ?,?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, inventory_id);
                statement.setInt(2, fish_id);
                statement.setInt(3, qnt);
                statement.setDate(4, new java.sql.Date(last_update.getTime()));  
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Inventory Item added successfully!");
                    }

            } 
            catch (SQLException e) {
                 System.err.println("Error occurred while adding Order with id: " +inventory_id  + e.getMessage());
                e.printStackTrace();
            }
        
        }
        public static boolean check_inid(Connection connection, int id){
                String checkQuery = "SELECT COUNT(*) FROM inventory WHERE inventory_id = ?";
               try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
                   statement.setInt(1, id);
                   ResultSet resultSet = statement.executeQuery();
                   return resultSet.next() && resultSet.getInt(1) > 0;
               } catch (SQLException e) {
                   e.printStackTrace();
               }
               return false;
           }     
        public static void edit_Inventory_Item(int item_id , int fish_id, int qnt , Date last_update ,
                Connection connection){
            String query = "Update inventory SET fish_id= ? , qnt = ? , last_updated = ? "
                    + "WHERE inventory_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {            
                statement.setInt(1, fish_id);
                statement.setInt(2, qnt);
                statement.setDate(3, new java.sql.Date(last_update.getTime()));    
                statement.setInt(4, item_id);

                if(check_inid(connection,item_id)){                
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Item Edited successfully!");
                    }
                }
                else{
                       System.out.println("Item not found!");
                }
            } 
            catch (SQLException e) {
                 System.err.println("Error occurred while editing item with id: " +item_id +e.getMessage());
                e.printStackTrace();
            }

            }
        public static void deleteItem(int item_id , Connection connection){
             String query = "Delete from inventory WHERE inventory_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {            
                    statement.setInt(1, item_id);
                    if(check_inid(connection,item_id)){                
                        int rowsDeleted  = statement.executeUpdate();
                        if (rowsDeleted  > 0) {
                            System.out.println("Item deleted successfully!");
                        }
                    }
                    else{
                           System.out.println("Item not found!");
                    }
                } 
                catch (SQLException e) {
                   System.err.println("Error occurred while deleting item with id: " +item_id+ e.getMessage());
                    e.printStackTrace();
                }
        }
        public static void delete_all_Items( Connection connection){
             String query = "Delete from inventory ";
                try (PreparedStatement statement = connection.prepareStatement(query)) {            
                        int rowsDeleted  = statement.executeUpdate();
                        if (rowsDeleted  > 0) {
                            System.out.println("Items deleted successfully!");
                        }
                        else{
                            System.out.println("no item to be deleted!");
                        }
                } 
                catch (SQLException e) {
                   System.err.println("Error occurred while deleting items " + e.getMessage());
                    e.printStackTrace();
                }
        }
        public static void list_inventory_item(Connection connection , int item_id){
             String query = "SELECT * from  inventory WHERE inventory_id = ?";
         try(PreparedStatement pstmt = connection.prepareStatement(query)){ 
                    pstmt.setInt(1, item_id); 
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                    System.out.println("\nItem ID: " + rs.getInt("inventory_id"));
                    System.out.println("Fish ID: " +rs.getInt("fish_id"));
                    System.out.println("Quantity: " +rs.getInt("qnt"));
                    System.out.println("last update : " + rs.getDate("last_updated"));
                    System.out.println("-----------------------");
                    } 
                    else {
                     System.out.println("Item with ID " + item_id + " does not exist.");
                     System.out.println("-----------------------");
                    }
                    rs.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing items: " + e.getMessage());
                }
         }   
        public static void list_all_inventory_items(Connection connection ){
             String query = "SELECT * from  inventory ";
         try(PreparedStatement pstmt = connection.prepareStatement(query)){ 
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                    System.out.println("\nItem ID: " + rs.getInt("inventory_id"));
                    System.out.println("Fish ID: " +rs.getInt("fish_id"));
                    System.out.println("Quantity: " +rs.getInt("qnt"));
                    System.out.println("last update : " + rs.getDate("last_updated"));
                    System.out.println("-----------------------");
                    } 
                    rs.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing items: " + e.getMessage());
                }
         }   
        public static boolean check_inidbk(Connection connection, int id){
                String checkQuery = "SELECT COUNT(*) FROM inventory_backup WHERE inventory_id = ?";
               try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
                   statement.setInt(1, id);
                   ResultSet resultSet = statement.executeQuery();
                   return resultSet.next() && resultSet.getInt(1) > 0;
               } catch (SQLException e) {
                   e.printStackTrace();
               }
               return false;
           }         
        public static void backup_Inventory(Connection connection){
            String selectFish = "SELECT * FROM inventory";
            String insertBackup = "INSERT INTO inventory_backup (inventory_id,fish_id, qnt, last_updated) VALUES (?,?, ?, ?)";

        try (PreparedStatement selectStmt = connection.prepareStatement(selectFish);
            ResultSet rs = selectStmt.executeQuery();
            PreparedStatement insertStmt = connection.prepareStatement(insertBackup)) {

           while (rs.next()) {

               int item_id = rs.getInt("inventory_id");
               int fish_id = rs.getInt("fish_id");
               int qnt = rs.getInt("qnt");
               Date date = rs.getDate("last_updated");
               if(!check_inidbk(connection , item_id)){
               insertStmt.setInt(1, item_id);
               insertStmt.setInt(2, fish_id);
               insertStmt.setInt(3,qnt);
               insertStmt.setDate(4, new java.sql.Date(date.getTime()));

               int rowsInserted = insertStmt.executeUpdate();
               if (rowsInserted > 0) {
                   System.out.println("item with ID " + item_id + " backed up successfully.");
               } else {
                   System.out.println("item with ID " + item_id + " already exists in the backup.");
               }
           }
           }
        } catch (SQLException e) {
            System.err.println("Error while backing up Orders data: " + e.getMessage());
            e.printStackTrace();
        } 
             }        
        public static void restore_Inventory(Connection connection){
            String selectFish = "SELECT * FROM inventory_backup";
            String insertBackup = "INSERT INTO inventory (inventory_id,fish_id, qnt, last_updated) VALUES (?,?, ?, ?)";

        try (PreparedStatement selectStmt = connection.prepareStatement(selectFish);
            ResultSet rs = selectStmt.executeQuery();
            PreparedStatement insertStmt = connection.prepareStatement(insertBackup)) {

           while (rs.next()) {

               int item_id = rs.getInt("inventory_id");
               int fish_id = rs.getInt("fish_id");
               int qnt = rs.getInt("qnt");
               Date date = rs.getDate("last_updated");
               if(!check_inid(connection , item_id)){
               insertStmt.setInt(1, item_id);
               insertStmt.setInt(2, fish_id);
               insertStmt.setInt(3,qnt);
               insertStmt.setDate(4, new java.sql.Date(date.getTime()));

               int rowsInserted = insertStmt.executeUpdate();
               if (rowsInserted > 0) {
                   System.out.println("item with ID " + item_id + " restored successfully.");
               } else {
                   System.out.println("item with ID " + item_id + " already exists in the table.");
               }
           }
           }
        } catch (SQLException e) {
            System.err.println("Error while backing up inventory data: " + e.getMessage());
            e.printStackTrace();
        } 
             }
        
        }
    public class Order_detail{
        int row_id;
        int order_id;
        int fish_id;
        int quantity;
        long subtotal;
        
        public void setRow_id(int rid){
            this.row_id = rid;
        }
        public void setOrder_id(int oid){
            this.order_id = oid;
        }
        public void setQuantity(int qnt){
            this.quantity = qnt;
        }
        public void setSubtotal(long subtotal){
            this.subtotal = subtotal;
        }
        public int getRow_id(){
            return this.row_id;
        }
        public int getOrder_id(){
            return this.order_id;
        }
        public int getQuantity(){
            return this.quantity;
                    }
        public long getSubtotal(){
            return this.subtotal;}
        public static boolean checkoid(Connection connection, int oid){
         String checkQuery = "SELECT COUNT(*) FROM orders WHERE order_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
            statement.setInt(1, oid);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() && resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        }
         public static boolean checkridbk(Connection connection, int id){
         String checkQuery = "SELECT COUNT(*) FROM OrderDetails_backup WHERE row_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() && resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        }
         public static boolean checkrid(Connection connection, int id){
         String checkQuery = "SELECT COUNT(*) FROM OrderDetails WHERE row_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() && resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        }
         public static boolean checkfid(Connection connection, int fid){
         String checkQuery = "SELECT COUNT(*) FROM fish WHERE fish_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
            statement.setInt(1, fid);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() && resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        }
        public static void addRow(int row_id,int order_id ,int fish_id, int qnt , long subtotal , Connection connection){
        String query = "INSERT INTO OrderDetails ( row_id,order_id, fish_id, quantity,subtotal) VALUES (?, ?, ?, ?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {  
                statement.setInt(1, row_id);               
                statement.setInt(2, order_id);
                statement.setInt(3, fish_id);
                statement.setInt(4, qnt);
                statement.setLong(5, subtotal);
                if(checkoid(connection , order_id) && checkfid(connection,fish_id) && !checkrid(connection,row_id)){
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Order detail added successfully!");
                    }
                }
                else{
                    System.out.println("Error due to keys!");
                }
            } 
            catch (SQLException e) {
                 System.err.println("Error occurred while adding Order detail with id: " +row_id+ ". " + e.getMessage());
                e.printStackTrace();
            }
        
        
        }
        public static void editOrder_detail(Connection connection,int row_id ,int order_id,int fish_id , 
                int quantity,long subtotal ) {
        String query = "Update OrderDetails SET order_id= ? , fish_id = ? ,subtotal = ? ,quantity = ?  "
                + "WHERE row_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {            
            statement.setInt(1, order_id);
            statement.setInt(2, fish_id);
            statement.setInt(4, quantity);
            statement.setLong(3, subtotal);
            statement.setInt(5, row_id);
            
            if(checkfid(connection,fish_id) && checkoid(connection,order_id) && checkrid(connection , row_id)){                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Order detail Edited successfully!");
                }
            }
            else{
                   System.out.println("fish_id or order_id not found!");
            }
        } 
        catch (SQLException e) {
             System.err.println("Error occurred while editing order detail with id: " +row_id +e.getMessage());
            e.printStackTrace();
        }
         }   
        public static void delete_row(int row_id , Connection connection){
                String query = "Delete from OrderDetails WHERE row_id = ?";
               try (PreparedStatement statement = connection.prepareStatement(query)) {            
                   statement.setInt(1, row_id);        
                       int rowsDeleted  = statement.executeUpdate();
                       if (rowsDeleted  > 0) {
                           System.out.println("row deleted successfully!");
                       }
                        else{
                            System.out.println("no item to be deleted!");
                        }
               } 
               catch (SQLException e) {
                  System.err.println("Error occurred while deleting row with id: " +row_id+ e.getMessage());
                   e.printStackTrace();
               }
           }
        public static void delete_all_rows( Connection connection){
                String query = "Delete from OrderDetails ";
               try (PreparedStatement statement = connection.prepareStatement(query)) {                  
                       int rowsDeleted  = statement.executeUpdate();
                       if (rowsDeleted  > 0) {
                           System.out.println("rows deleted successfully!");
                       }
                        else{
                            System.out.println("no item to be deleted!");
                        }
               } 
               catch (SQLException e) {
                  System.err.println("Error occurred while deleting rows  "+ e.getMessage());
                   e.printStackTrace();
               }
    }
        public static void listRow(Connection connection , int row_id){
             String query = "SELECT * from  OrderDetails WHERE row_id = ?";
         try(PreparedStatement pstmt = connection.prepareStatement(query)){ 
                    pstmt.setInt(1, row_id); 
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                    System.out.println("Row ID: " +rs.getInt("row_id"));
                    System.out.println("Order ID: " + rs.getInt("order_id"));
                    System.out.println("fish ID: " +rs.getInt("fish_id"));
                    System.out.println("quantity: " +rs.getInt("quantity"));
                    System.out.println("subTotal: " + rs.getLong("subtotal"));
                    System.out.println("-----------------------");
                    } 
                    else {
                     System.out.println("row with ID " + row_id + " does not exist.");
                     System.out.println("-----------------------");
                    }
                    rs.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing Order detail: " + e.getMessage());
                }
         }   
        public static void list_all_rows(Connection connection){
             String query = "SELECT * from  OrderDetails ";
         try(PreparedStatement pstmt = connection.prepareStatement(query)){ 
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                    System.out.println("Row ID: " +rs.getInt("row_id"));
                    System.out.println("Order ID: " + rs.getInt("order_id"));
                    System.out.println("fish ID: " +rs.getInt("fish_id"));
                    System.out.println("quantity: " +rs.getInt("quantity"));
                    System.out.println("subTotal: " + rs.getLong("subtotal"));
                    System.out.println("-----------------------");
                    } 
                    rs.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing Orders: " + e.getMessage());
                }
         } 
        public static void backup_row(Connection connection){
            String selectFish = "SELECT * FROM OrderDetails";
            String insertBackup = "INSERT INTO OrderDetails_backup (row_id,order_id,fish_id, subtotal, quantity) VALUES (?,?, ?, ?, ?)";

        try (PreparedStatement selectStmt = connection.prepareStatement(selectFish);
            ResultSet rs = selectStmt.executeQuery();
            PreparedStatement insertStmt = connection.prepareStatement(insertBackup)) {

           while (rs.next()) {
               int row_id = rs.getInt("row_id");
               int oid = rs.getInt("order_id");
               int fid = rs.getInt("fish_id");
               long subtotal = rs.getLong("subtotal");
               int qnt = rs.getInt("quantity");
               if(!checkridbk(connection , row_id)){
               insertStmt.setInt(1, row_id);
               insertStmt.setInt(2, oid);
               insertStmt.setInt(3, fid);
               insertStmt.setLong(4,subtotal);
               insertStmt.setInt(5, qnt);


               int rowsInserted = insertStmt.executeUpdate();
               if (rowsInserted > 0) {
                   System.out.println("row with ID " + row_id + " backed up successfully.");
               } else {
                   System.out.println("row with ID " + row_id + " already exists in the backup.");
               }
           }
           }
        } catch (SQLException e) {
            System.err.println("Error while backing up row data: " + e.getMessage());
            e.printStackTrace();
        } 
             }
        
        public static void restore_row(Connection connection){
            String selectFish = "SELECT * FROM OrderDetails_backup";
            String insertBackup = "INSERT INTO OrderDetails (row_id,order_id,fish_id, subtotal, quantity) VALUES (?,?, ?, ?, ?)";

        try (PreparedStatement selectStmt = connection.prepareStatement(selectFish);
            ResultSet rs = selectStmt.executeQuery();
            PreparedStatement insertStmt = connection.prepareStatement(insertBackup)) {

           while (rs.next()) {
               int row_id = rs.getInt("row_id");
               int oid = rs.getInt("order_id");
               int fid = rs.getInt("fish_id");
               long subtotal = rs.getLong("subtotal");
               int qnt = rs.getInt("quantity");         
               insertStmt.setInt(1, row_id);
               insertStmt.setInt(2, oid);
               insertStmt.setInt(3, fid);
               insertStmt.setLong(4,subtotal);
               insertStmt.setInt(5, qnt);
               if(!checkrid(connection , row_id)){
               int rowsInserted = insertStmt.executeUpdate();
               if (rowsInserted > 0) {
                   System.out.println("row with ID " + row_id + " restored successfully.");
              
           }}
               else{
                   System.out.println("row with ID " + row_id + " exist.");
               }  
           }
        } catch (SQLException e) {
            System.err.println("Error while restoring row data: " + e.getMessage());
            e.printStackTrace();
        } 
             }
        
    }
        
    }
    

    
