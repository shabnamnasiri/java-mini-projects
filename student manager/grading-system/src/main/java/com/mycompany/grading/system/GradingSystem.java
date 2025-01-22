/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grading.system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

;

/**
 *
 * @author Lenovo
 */
public class GradingSystem {


    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/my_GradingSystem";
        String username = "root";
        String password = "22703380";

        try {
          
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to MySQL established!");
//           
//                //adding students to table student
                Date bd1 = format_Date("12/04/2021");
                Student.add_student("189222", "Ayse", "Cengiz", 'F', "Turkey", bd1, conn);

                Date bd2 = format_Date("16/09/2003");
                Student.add_student("193342", "Philip", "Udoye", 'M', "Nigeria", bd2, conn);

                 Date bd3 = format_Date("17/05/2002");
                 Student.add_student("189931", "Kemal", "Salih", 'M', "TRNC", bd3, conn);

                 Date bd4 = format_Date("22/11/2001");
                 Student.add_student("188883", "Fathima", "Mohammad", 'F', "Syria", bd4, conn);

                 Date bd5 = format_Date("19/02/2002");
                Student.add_student("189447", "Jasmin", "Faruq", 'F', "Egypt", bd5, conn);

                Student.list_all_students(conn);
//
//                    //adding departments to databse
                  Department.add_department("Information Technology", conn);
                  Department.add_department("Enconomics", conn);
                  Department.add_department("Business", conn);
                  Department.list_all_departments(conn);
//
//                  //adding all courses to database
                 Course.add_course(13,"ITEC314","Multi Platform Programming", conn);
                 Course.add_course(13,"ITEC413","Information Systems Security", conn);
                 Course.add_course(16,"ECON101","Introduction to Economics", conn);
                 Course.add_course(15,"BUSS103","Fundamentals of Business Administration", conn);
                 Course.list_all_courses(conn);

//                 //adding all grades
                Grades.add_grade(27, 20, 90, 88, 96, "A", conn);
                Grades.add_grade(28, 21, 80, 85, 82, "B+", conn);
                Grades.add_grade(29, 21, 75, 80, 77, "B-", conn);
                Grades.add_grade(30, 21, 69, 75, 66, "C+", conn);
                Grades.add_grade(31, 20, 88, 80, 82, "A+", conn);
                Grades.listAllGrades(conn);
//                
//                //adding all attendance
                Date att1 = format_Date("09/04/2021");
                Attendance.addAttendance(27, 20, att1, conn);
                
                Date att2 = format_Date("09/04/2021");
                Attendance.addAttendance(28, 20, att2, conn);
                
                Date att3 = format_Date("09/04/2021");
                Attendance.addAttendance(29, 21, att3, conn);
                
                Date att4 = format_Date("09/04/2021");
                Attendance.addAttendance(30, 21, att4, conn);
                
                Date att5 = format_Date("09/04/2021");
                Attendance.addAttendance(31, 20, att5, conn);
                
                Date att6 = format_Date("12/04/2021");
                Attendance.addAttendance(27, 20, att6, conn);

                Date att7 = format_Date("12/04/2021");
                Attendance.addAttendance(28, 20, att7, conn);
                
                Date att8 = format_Date("12/04/2021");
                Attendance.addAttendance(29, 21, att8, conn);
//                
                Attendance.listAllAttendance(conn);
//                
//                  //editing the second object 
                  Date birthdate = format_Date("27/07/2004");
                 Student.edit_student(28, "22703380", "shabnam", "nasiri", 'F', "Iran", birthdate, conn);
                
                 Department.edit_department(14, "Mathematics", conn);
                 
                 Course.edit_course(15, 13, "ITEC315", "analysis", conn);
                 
                 Grades.edit_grade(27,28,15, 100, 90, 88, "A-", conn);
                 
                 Date attedit = format_Date("27/07/2024");
                 Attendance.editAttendance(20,27,14,attedit,conn);
//                
//                 //listing all
                  Student.list_all_students(conn);
                  Department.list_all_departments(conn);
                  Course.list_all_courses(conn);
                  Grades.listAllGrades(conn);
                  Attendance.listAllAttendance(conn);
//                  
//                  //backup
                  Student.backup_students(conn);
                  Department.backup_departments(conn);
                  Course.backup_courses(conn);
                  Grades.backupGrades(conn);
                  Attendance.backupAttendance(conn);
//                  
//                  //delete
                  Student.delete_student(29,conn);
                  Department.delete_department(15, conn);
                  Course.delete_course(16, conn);
                  Grades.deleteGradeById(28, conn);
                  Attendance.deleteAttendanceById(21, conn);
//                  
//                  //listing all
                  Student.list_all_students(conn);
                  Department.list_all_departments(conn);
                  Course.list_all_courses(conn);
                  Grades.listAllGrades(conn);
                  Attendance.listAllAttendance(conn);
//                  
//                  //restoring
                  Student.restore_students(conn);
                  Department.restore_departments(conn);
                  Course.restore_courses(conn);
                  Grades.restoreGrades(conn);
                  Attendance.restoreAttendance(conn);
//                  
//                  //listing all
                  Student.list_all_students(conn);
                  Department.list_all_departments(conn);
                  Course.list_all_courses(conn);
                  Grades.listAllGrades(conn);
                  Attendance.listAllAttendance(conn);
                  
//                  
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//    

        
        
    }
    
public static java.sql.Date format_Date(String date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Adjust format as needed
    dateFormat.setLenient(false); // Strict date validation
    java.sql.Date sqlDate = null;

    try {
        // Parse the date and convert to java.sql.Date
        java.util.Date parsedDate = dateFormat.parse(date);
        sqlDate = new java.sql.Date(parsedDate.getTime());
    } catch (Exception e) {
        System.err.println("Invalid date format: " + date);
        e.printStackTrace();
    }

    return sqlDate;
}

    public static class Student{
        int std_id;
        String std_no;
        String std_name;
        String std_surname;
        char std_gender;
        String std_nationality;
        Date std_birthday;       
        
        //I didn't use set method for id cause it's using auto increament in database
        public void set_std_id(int std_id){
            this.std_id=std_id;
        }
        public void set_std_no(String no){
            this.std_no=no;
        }
        public void set_name(String name){
            this.std_name=name;
        }
        public void set_surname(String surname){
            this.std_surname=surname;
        }
        public void set_gender(char gender){
            this.std_gender = gender;
        }
        public void set_nationality(String nationality){
            this.std_nationality = nationality;
        }
        public void set_birthday(Date birthdate){
            this.std_birthday = birthdate;
        }
        public int get_std_id(){
            return this.std_id;
        }
        public String get_std_no(){
            return this.std_no;
        }
        public String get_name(){
            return this.std_name;
        }
         public String get_surname(){
            return this.std_surname;
        }
        public char get_gender(){
            return this.std_gender;
        }
        public String get_nationality(){
            return this.std_nationality;
        }
        public Date get_birthday(){
            return this.std_birthday;
        }
        
        public static boolean check_stdno(String std_no, Connection conn) {
            try {
                // SQL query to check if the student number exists or not 
                String query = "SELECT COUNT(*) FROM Student WHERE std_no = ?";

                // Use a PreparedStatement to prevent SQL injection
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, std_no);

                // Execute the query and get the result
                ResultSet rs = pstmt.executeQuery();

                // Check the result
                if (rs.next()) {
                    int count = rs.getInt(1); // Get the count value
                    return count > 0; // Return true if count > 0, false otherwise
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while checking student number: " + e.getMessage());
            }
            return false; // Return false in case of exception
        }
        //my tables id are auto inceament so i dont pass id
        public static void add_student(String no, String name, String surname, 
                    char gender, String nationality, Date birthdate ,Connection conn) {
            try {
               
                String insertQuery = "INSERT INTO Student (std_no, std_name,"
                        + " std_surname, std_gender, std_nationality, "
                        + "std_birthday) VALUES (?, ?, ?, ?, ?, ?)";

                // Use a PreparedStatement to set the parameterized values
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);
                pstmt.setString(1, no);
                pstmt.setString(2, name);
                pstmt.setString(3, surname);
                pstmt.setString(4, String.valueOf(gender)); 
                pstmt.setString(5, nationality);
                pstmt.setDate(6, new java.sql.Date(birthdate.getTime())); // Convert java.util.Date to java.sql.Date
                //no need to check for id it's auto increament
                if(!check_stdno(no , conn) ){
                pstmt.executeUpdate();
                System.out.println("Student added successfully: " + name);
                    }
                else{
                 System.out.println("Student already exist : " + name);
                   }


            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while adding student: " + e.getMessage());
            }
        }
        
        public static void delete_student(int id, Connection conn) {
        try {
        
        String deleteQuery = "DELETE FROM Student WHERE std_id = ?";
        
        // Prepare the statement
        PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
        pstmt.setInt(1, id); // Set the student ID for the WHERE clause
        
        // Execute the delete
        int rowsAffected = pstmt.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Student with ID " + id + " has been deleted.");
        } else {
            System.out.println("Student with ID " + id + " does not exist.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error while deleting student: " + e.getMessage());
    }
}

        
        public static void edit_student(int id, String no, String name, String surname, 
                                         char gender, String nationality, Date birthdate, Connection conn) {
            try {
                // SQL UPDATE query
                String updateQuery = "UPDATE Student SET std_no = ?, std_name = ?, std_surname = ?, std_gender = ?, std_nationality = ?, std_birthday = ? WHERE std_id = ?";

                // Prepare the statement
                PreparedStatement pstmt = conn.prepareStatement(updateQuery);
                pstmt.setString(1, no);
                pstmt.setString(2, name);
                pstmt.setString(3, surname);
                pstmt.setString(4, String.valueOf(gender)); // Convert char to String
                pstmt.setString(5, nationality);
                pstmt.setDate(6, new java.sql.Date(birthdate.getTime())); // Convert java.util.Date to java.sql.Date
                pstmt.setInt(7, id); // Set the student ID for the WHERE clause

                // Execute the update
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Student with ID " + id + " updated successfully!");
                } else {
                    System.out.println("Student with ID " + id + " does not exist.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while updating student: " + e.getMessage());
            }
        }
        
            public static void list_student(int id, Connection conn) {
                try {
                    // SQL SELECT query to retrieve student by ID
                    String selectQuery = "SELECT * FROM Student WHERE std_id = ?";

                    // Prepare the statement
                    PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                    pstmt.setInt(1, id);  // Set the student ID as a parameter

                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();

                    // Check if the result set contains any row (i.e., student exists)
                    if (rs.next()) {
                        // Print student details
                        System.out.println("\nStudent ID: " + rs.getInt("std_id"));
                        System.out.println("Student No: " + rs.getString("std_no"));
                        System.out.println("Name: " + rs.getString("std_name") + " " + rs.getString("std_surname"));
                        System.out.println("Gender: " + rs.getString("std_gender"));
                        System.out.println("Nationality: " + rs.getString("std_nationality"));
                        System.out.println("Birthday: " + rs.getDate("std_birthday"));
                        System.out.println("-----------------------");
                    } else {
                        System.out.println("Student with ID " + id + " does not exist.");
                        System.out.println("-----------------------");
                    }

                    // Close the ResultSet
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing student: " + e.getMessage());
                }
            }
            public static void list_all_students(Connection conn) {
                try {
                    // SQL SELECT query to retrieve all students
                    String selectQuery = "SELECT * FROM Student";

                    // Prepare the statement
                    PreparedStatement pstmt = conn.prepareStatement(selectQuery);

                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();

                    // Check if there are any students in the result set
                    if (!rs.isBeforeFirst()) {
                        System.out.println("No students available.");
                    } else {
                        // Iterate through the result set and print all student details
                        while (rs.next()) {
                            System.out.println("Student ID: " + rs.getInt("std_id"));
                            System.out.println("Student No: " + rs.getString("std_no"));
                            System.out.println("Name: " + rs.getString("std_name") + " " + rs.getString("std_surname"));
                            System.out.println("Gender: " + rs.getString("std_gender"));
                            System.out.println("Nationality: " + rs.getString("std_nationality"));
                            System.out.println("Birthday: " + rs.getDate("std_birthday"));
                            System.out.println("---------------------------");
                        }
                    }

                    // Close the ResultSet
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing all students: " + e.getMessage());
                }
            }
            public static void delete_all_students(Connection conn) {
                try {
                    // SQL DELETE query to remove all students from the table
                    String deleteQuery = "DELETE FROM Student";

                    // Prepare the statement
                    PreparedStatement pstmt = conn.prepareStatement(deleteQuery);

                    // Execute the delete operation
                    int rowsAffected = pstmt.executeUpdate();

                    // Check if any rows were affected
                    if (rowsAffected > 0) {
                        System.out.println("All students have been deleted.");
                    } else {
                        System.out.println("No students were found to delete.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while deleting all students: " + e.getMessage());
                }
            }
            public static void backup_students(Connection conn) {
                        try {
                            // SQL query to retrieve data from the student table
                            String selectQuery = "SELECT * FROM student";
                            Statement stmt = conn.createStatement();
                            ResultSet rs = stmt.executeQuery(selectQuery);

                            // Prepare the SQL query to insert data into the student_backup table
                            String insertQuery = "INSERT IGNORE INTO student_backup (std_id, std_no, std_name, "
                                    + "std_surname, std_gender, std_nationality, std_birthday) "
                                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

                            // Prepare the PreparedStatement for insertion
                            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);

                            while (rs.next()) {
                                //getting the id of each row of student table 
                                int stdId = rs.getInt("std_id");

                                
                                // Check if the student already exists in the backup table
                                String checkQuery = "SELECT COUNT(*) FROM student_backup WHERE std_id = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
                                checkStmt.setInt(1, stdId);
                                ResultSet checkRs = checkStmt.executeQuery();

                                // If student does not exist in the backup table, insert it
                                if (checkRs.next() && checkRs.getInt(1) == 0) {
                                    insertStmt.setInt(1, stdId);
                                    insertStmt.setString(2, rs.getString("std_no"));
                                    insertStmt.setString(3, rs.getString("std_name"));
                                    insertStmt.setString(4, rs.getString("std_surname"));
                                    insertStmt.setString(5, rs.getString("std_gender"));
                                    insertStmt.setString(6, rs.getString("std_nationality"));
                                    insertStmt.setDate(7, rs.getDate("std_birthday"));  // Assuming birthdate is stored as DATE in student table

                                    // Execute the insertion into the backup table
                                    insertStmt.executeUpdate();
                                }

                                checkRs.close();  // Close the check result set
                                checkStmt.close();  // Close the check statement
                            }

                            System.out.println("Students backed up to the backup table successfully.");
                        } catch (SQLException e) {
                            System.out.println("Error backing up students: " + e.getMessage());
                        }
                    }
                    
                    
            public static void restore_students(Connection conn) {
                try {
                    // SQL query to retrieve data from the student_backup table
                    String selectQuery = "SELECT * FROM student_backup";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(selectQuery);

                    // Prepare the SQL query to insert data into the original students table
                    String insertQuery = "INSERT IGNORE  INTO student (std_id, std_no, std_name, std_surname, std_gender, std_nationality, std_birthday) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

                    // Prepare the PreparedStatement for insertion
                    PreparedStatement insertStmt = conn.prepareStatement(insertQuery);

                    // Iterate through the result set and insert each student into the students table
                    while (rs.next()) {
                         int stdId = rs.getInt("std_id");

                    // Check if the student already exists
                    String checkQuery = "SELECT COUNT(*) FROM student WHERE std_id = ?";
                    PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
                    checkStmt.setInt(1, stdId);
                    ResultSet checkRs = checkStmt.executeQuery();

                    if (checkRs.next() && checkRs.getInt(1) == 0) {
                        // Set the student data for insertion
                        insertStmt.setInt(1, rs.getInt("std_id"));
                        insertStmt.setString(2, rs.getString("std_no"));
                        insertStmt.setString(3, rs.getString("std_name"));
                        insertStmt.setString(4, rs.getString("std_surname"));
                        insertStmt.setString(5, rs.getString("std_gender"));
                        insertStmt.setString(6, rs.getString("std_nationality"));
                        insertStmt.setDate(7, rs.getDate("std_birthday"));  // Assuming the birthdate is stored as DATE in backup

                        // Execute the insertion into the original students table
                        insertStmt.executeUpdate();       
                    }
                    checkRs.close();  // Close the check result set
                    checkStmt.close();  // Close the check statement
                    }

                    System.out.println("Students restored to the original table successfully.");
                } catch (SQLException e) {
                    System.out.println("Error restoring students from backup: " + e.getMessage());
                }
            }
            
           }
    
    public static class Course{
        int crs_id;
        int dept_id;
        String crs_code;
        String crs_name;
        

        public void  set_crs_id(int crs_id){
           this.crs_id = crs_id;
        }
        public void set_dept_id(int dept_id){
             this.dept_id = dept_id;
        }
        public void set_crs_code(String crs_code){
            this.crs_code=crs_code;
        }
        public void set_crs_name(String crs_name){
            this.crs_name = crs_name;
        }
        public int get_crs_id(){
            return this.crs_id;
        }
        public int get_dept_id(){
            return this.dept_id;
        }
        public String get_crs_code(){
            return this.crs_code;
        }
        public String get_crs_name(){
            return this.crs_name;
        }
        
        public static boolean check_course(String crs_code , Connection conn){
             try {
                // SQL query to check if the student number exists or not 
                String query = "SELECT COUNT(*) FROM Course WHERE crs_code = ?";

                // Use a PreparedStatement to prevent SQL injection
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, crs_code);

                // Execute the query and get the result
                ResultSet rs = pstmt.executeQuery();

                // Check the result
                if (rs.next()) {
                    int count = rs.getInt(1); // Get the count value
                    return count > 0; // Return true if count > 0, false otherwise
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while checking course code: " + e.getMessage());
            }
            return false; // Return false in case of exception
        }
        public static void add_course(int dept_id, String crs_code, String crs_name, Connection conn) {
            try {
                // Prepare the SQL statement
                String sql = "INSERT INTO Course (dept_id, crs_code, crs_name) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);

                // Set the values for the query
                stmt.setInt(1, dept_id);
                stmt.setString(2, crs_code);
                stmt.setString(3, crs_name);

                //check if dept exist
                if(check_department_exists(dept_id,conn)){
                    //check if course exist
                    if(!check_course(crs_code,conn)){
                          stmt.executeUpdate();
                          System.out.println("Course added successfully!");  
                    }
                    else{
                          System.out.println("Course already exist!");
                    }

                }
                else{
                 System.out.println("Department doesn't exist!");  
                }
                
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void edit_course(int crs_id, int dept_id, String crs_code, String crs_name, Connection conn) {
            try {
                if(check_department_exists(dept_id,conn)){
                    // Department exists, proceed with the course update
                    String updateCourseSQL = "UPDATE course SET dept_id = ?, crs_code = ?, crs_name = ? WHERE crs_id = ?";
                    PreparedStatement updateCourseStmt = conn.prepareStatement(updateCourseSQL);
                    updateCourseStmt.setInt(1, dept_id);
                    updateCourseStmt.setString(2, crs_code);
                    updateCourseStmt.setString(3, crs_name);
                    updateCourseStmt.setInt(4, crs_id);

                    int rowsUpdated = updateCourseStmt.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Course updated successfully!");
                    } else {
                        System.out.println("Course with ID " + crs_id + " not found.");
                    }
                } 
                else {
                    // Department does not exist
                    System.out.println("Department with ID " + dept_id + " does not exist. Update failed.");
                }
            
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static boolean check_department_exists(int dept_id, Connection conn) {
            try {
                String sql = "SELECT COUNT(*) FROM department WHERE dept_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, dept_id);

                ResultSet rs = stmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    return true; // Department exists
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false; // Department does not exist
        }
        public static void delete_course(int crs_id, Connection conn) {
            try {
                String sql = "DELETE FROM course WHERE crs_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, crs_id);

                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Course with ID " + crs_id + " was deleted successfully.");
                } else {
                    System.out.println("Course with ID " + crs_id + " does not exist.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void list_course(int crs_id, Connection conn) {
            try {
                String sql = "SELECT * FROM course WHERE crs_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, crs_id);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Course ID: " + rs.getInt("crs_id"));
                    System.out.println("Department ID: " + rs.getInt("dept_id"));
                    System.out.println("Course Code: " + rs.getString("crs_code"));
                    System.out.println("Course Name: " + rs.getString("crs_name"));
                } else {
                    System.out.println("Course with ID " + crs_id + " not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void list_all_courses(Connection conn) {
            try {
                String sql = "SELECT * FROM course";
                PreparedStatement stmt = conn.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("Course ID: " + rs.getInt("crs_id"));
                    System.out.println("Department ID: " + rs.getInt("dept_id"));
                    System.out.println("Course Code: " + rs.getString("crs_code"));
                    System.out.println("Course Name: " + rs.getString("crs_name"));
                    System.out.println("-----------------------------");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void delete_all_courses(Connection conn) {
            try {
                String sql = "DELETE FROM course";
                PreparedStatement stmt = conn.prepareStatement(sql);

                int rowsAffected = stmt.executeUpdate();

                    // Check if any rows were affected
                    if (rowsAffected > 0) {
                        System.out.println("All Courses have been deleted.");
                    } else {
                        System.out.println("No Course were found to delete.");
                    }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void backup_courses(Connection conn) {
            try {
                // Select all courses from the course table
                String selectCoursesSQL = "SELECT crs_id, dept_id, crs_code, crs_name FROM course";
                PreparedStatement selectCoursesStmt = conn.prepareStatement(selectCoursesSQL);
                ResultSet courseResultSet = selectCoursesStmt.executeQuery();

                // Loop through each course and check if it exists in the backup table
                while (courseResultSet.next()) {
                    String courseCode = courseResultSet.getString("crs_code");

                    // Check if the course already exists in the course_backup table
                    String checkBackupSQL = "SELECT COUNT(*) FROM course_backup WHERE crs_code = ?";
                    PreparedStatement checkBackupStmt = conn.prepareStatement(checkBackupSQL);
                    checkBackupStmt.setString(1, courseCode);
                    ResultSet backupResultSet = checkBackupStmt.executeQuery();

                    if (backupResultSet.next() && backupResultSet.getInt(1) == 0) {
                        // If course does not exist in the backup table, insert it
                        String backupSQL = "INSERT IGNORE INTO course_backup (crs_id, dept_id, crs_code, crs_name) VALUES (?, ?, ?, ?)";
                        PreparedStatement backupStmt = conn.prepareStatement(backupSQL);
                        backupStmt.setInt(1, courseResultSet.getInt("crs_id"));
                        backupStmt.setInt(2, courseResultSet.getInt("dept_id"));
                        backupStmt.setString(3, courseResultSet.getString("crs_code"));
                        backupStmt.setString(4, courseResultSet.getString("crs_name"));
                        backupStmt.executeUpdate();
                        System.out.println("Backed up course: " + courseCode);
                    } else {
                        System.out.println("Course already exists in backup: " + courseCode);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void restore_courses(Connection conn) {
            try {
                // Select all courses from the course_backup table
                String selectBackupSQL = "SELECT crs_id, dept_id, crs_code, crs_name FROM course_backup";
                PreparedStatement selectBackupStmt = conn.prepareStatement(selectBackupSQL);
                ResultSet backupResultSet = selectBackupStmt.executeQuery();

                // Loop through each course in the backup table
                while (backupResultSet.next()) {
                    String courseCode = backupResultSet.getString("crs_code");

                    // Check if the course already exists in the course table
                    String checkCourseSQL = "SELECT COUNT(*) FROM course WHERE crs_code = ?";
                    PreparedStatement checkCourseStmt = conn.prepareStatement(checkCourseSQL);
                    checkCourseStmt.setString(1, courseCode);
                    ResultSet courseResultSet = checkCourseStmt.executeQuery();

                    if (courseResultSet.next() && courseResultSet.getInt(1) == 0) {
                        // If course does not exist in the course table, insert it
                        String restoreSQL = "INSERT IGNORE  INTO course (crs_id, dept_id, crs_code, crs_name) VALUES (?, ?, ?, ?)";
                        PreparedStatement restoreStmt = conn.prepareStatement(restoreSQL);
                        restoreStmt.setInt(1, backupResultSet.getInt("crs_id"));
                        restoreStmt.setInt(2, backupResultSet.getInt("dept_id"));
                        restoreStmt.setString(3, backupResultSet.getString("crs_code"));
                        restoreStmt.setString(4, backupResultSet.getString("crs_name"));

                        restoreStmt.executeUpdate();
                        System.out.println("Restored course: " + courseCode);
                    } else {
                        System.out.println("Course already exists in main table: " + courseCode);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static class Department{
        int dept_id;
        String dept_name;
        
        public void set_dept_id(int dept_id){
            this.dept_id = dept_id;
        }
        public void set_dept_name(String dept_name){
            this.dept_name = dept_name;
        }
        public int get_dept_id(){
            return this.dept_id;
        }
        public String get_name(){
            return this.dept_name;
        }
        
        public static boolean check_dept_name(String dept_name, Connection conn) {
            try {
                // SQL query to check if the student number exists or not 
                String query = "SELECT COUNT(*) FROM Department WHERE dept_name = ?";

                // Use a PreparedStatement to prevent SQL injection
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, dept_name);

                // Execute the query and get the result
                ResultSet rs = pstmt.executeQuery();

                // Check the result
                if (rs.next()) {
                    int count = rs.getInt(1); // Get the count value
                    return count > 0; // Return true if count > 0, false otherwise
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while checking Department Name: " + e.getMessage());
            }
            return false; // Return false in case of exception
        }
        public static void add_department( String dept_name,Connection conn){
            try {
               
                String insertQuery = "INSERT INTO Department (dept_name) VALUES (?)";

                // Use a PreparedStatement to set the parameterized values
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);
                pstmt.setString(1, dept_name);
                // Execute the query
                if(!check_dept_name(dept_name,conn)){                   
                pstmt.executeUpdate();
                System.out.println("Department added successfully: " + dept_name);
                }
                else{
                 System.out.println("Department already exist: " + dept_name);
                }

                }
            catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while adding Department: " + e.getMessage());
                }
        }
        
        public static void edit_department(int dept_id, String dept_name,Connection conn){
            try {
                // SQL UPDATE query
                String updateQuery = "UPDATE Department SET dept_name = ? WHERE dept_id = ?";

                // Prepare the statement
                PreparedStatement pstmt = conn.prepareStatement(updateQuery);
                pstmt.setString(1, dept_name);
                pstmt.setInt(2, dept_id);

                // Execute the update
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Department with ID " + dept_id + " updated successfully!");
                } else {
                    System.out.println("Department with ID " + dept_id + " does not exist.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while updating Department: " + e.getMessage());
            }

        }
        
        
        public static void delete_department (int dept_id , Connection conn){
                    try {
                    // SQL DELETE query
                    String deleteQuery = "DELETE FROM Department WHERE dept_id = ?";

                    // Prepare the statement
                    PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
                    pstmt.setInt(1, dept_id); // Set the department ID for the WHERE clause

                    // Execute the delete
                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Department with ID " + dept_id + " has been deleted.");
                    } else {
                        System.out.println("Department with ID " + dept_id + " does not exist.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while deleting Department: " + e.getMessage());
                }

        }
        
        public static void list_department(int dept_id,Connection conn){
            try {
                    // SQL SELECT query to retrieve dept by ID
                    String selectQuery = "SELECT * FROM Department WHERE dept_id = ?";

                    // Prepare the statement
                    PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                    pstmt.setInt(1, dept_id);  

                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();

                    // Check if the result set contains any row (i.e., dept exists)
                    if (rs.next()) {
                        System.out.println("\nDepartment ID: " + rs.getInt("dept_id"));
                        System.out.println("Department Name: " + rs.getString("dept_name") );
                        System.out.println("-----------------------");
                    } else {
                        System.out.println("Department with ID " + dept_id + " does not exist.");
                        System.out.println("-----------------------");
                    }

                    // Close the ResultSet
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing Department: " + e.getMessage());
                }
        }
        
        public  static void list_all_departments (Connection conn){
            try {
                    
                    String selectQuery = "SELECT * FROM Department";

                    // Prepare the statement
                    PreparedStatement pstmt = conn.prepareStatement(selectQuery);

                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();

                    // Check if there are any department in the result set
                    if (!rs.isBeforeFirst()) {
                        System.out.println("No Department available.");
                    } else {
                        // Iterate through the result set and print all department details
                        while (rs.next()) {
                        System.out.println("Department ID: " + rs.getInt("dept_id"));
                        System.out.println("Department Name: " + rs.getString("dept_name") );
                        System.out.println("-----------------------");
                        }
                    }

                    // Close the ResultSet
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while listing all Department: " + e.getMessage());
                }
        }
        
        public static void delete_all_departments(Connection conn){
            try {
                    // SQL DELETE query to remove all dept from the table
                    String deleteQuery = "DELETE FROM Department";

                    // Prepare the statement
                    PreparedStatement pstmt = conn.prepareStatement(deleteQuery);

                    // Execute the delete operation
                    int rowsAffected = pstmt.executeUpdate();

                    // Check if any rows were affected
                    if (rowsAffected > 0) {
                        System.out.println("All Departments have been deleted.");
                    } else {
                        System.out.println("No Department were found to delete.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while deleting all Department: " + e.getMessage());
                }
        }
        
         public static boolean isDepartmentInBackup(int deptId, Connection conn) {
                try {
                    String checkQuery = "SELECT COUNT(*) FROM Department_backup WHERE dept_id = ?";
                    PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
                    checkStmt.setInt(1, deptId);
                    ResultSet checkRs = checkStmt.executeQuery();

                    if (checkRs.next() && checkRs.getInt(1) > 0) {
                        checkRs.close();
                        checkStmt.close();
                        return true; // Department exists in the backup
                    }
                    checkRs.close();
                    checkStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error checking Department existence in backup: " + e.getMessage());
                }
                return false; // Department does not exist
            }
        public static void backup_departments(Connection conn){
                    try {
                            // SQL query to retrieve all data from the Department table
                            String selectQuery = "SELECT * FROM Department";
                            Statement stmt = conn.createStatement();
                            ResultSet rs = stmt.executeQuery(selectQuery);

                            // SQL query to insert data into the backup table
                            String insertQuery = "INSERT INTO Department_backup (dept_id, dept_name) VALUES (?, ?)";
                            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);

                            // Loop through all departments in the result set
                            while (rs.next()) {
                                int deptId = rs.getInt("dept_id");
                                String deptName = rs.getString("dept_name");

                                // Check if the department already exists in the backup table
                                if (isDepartmentInBackup(deptId, conn)) {
                                    System.out.println("Department with ID " + deptId + " already exists in the backup table.");
                                } else {
                                    // Insert the department into the backup table
                                    insertStmt.setInt(1, deptId);
                                    insertStmt.setString(2, deptName);
                                    insertStmt.executeUpdate();
                                    System.out.println("Department with ID " + deptId + " backed up successfully.");
                                }
                            }

                            System.out.println("Backup process completed.");
                        } catch (SQLException e) {
                            e.printStackTrace();
                            System.out.println("Error backing up Departments: " + e.getMessage());
                        }
        }
        
        public static  void restore_departments(Connection conn){
        try {
                    // SQL query to retrieve data from the student_backup table
                    String selectQuery = "SELECT * FROM Department_backup";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(selectQuery);

                    // Prepare the SQL query to insert data into the original students table
                    String insertQuery = "INSERT INTO Department (dept_id,  dept_name)VALUES (?, ?)";

                    // Prepare the PreparedStatement for insertion
                    PreparedStatement insertStmt = conn.prepareStatement(insertQuery);

                    while (rs.next()) {
                         int deptId = rs.getInt("dept_id");

                    // Check if the dept already exists
                    String checkQuery = "SELECT COUNT(*) FROM Department WHERE dept_id = ?";
                    PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
                    checkStmt.setInt(1, deptId);
                    ResultSet checkRs = checkStmt.executeQuery();

                    if (checkRs.next() && checkRs.getInt(1) == 0) {
                        // Set the student data for insertion
                        insertStmt.setInt(1, rs.getInt("dept_id"));
                        insertStmt.setString(2, rs.getString("dept_name"));

                        // Execute the insertion into the original students table
                        insertStmt.executeUpdate();       
                    }
                    checkRs.close();  // Close the check result set
                    checkStmt.close();  // Close the check statement
                    }

                    System.out.println("Departments restored to the original table successfully.");
                } catch (SQLException e) {
                    System.out.println("Error restoring Departments from backup: " + e.getMessage());
                }
            }    
        }

    public class Grades{
        int grd_id;
        int crs_id;
        int std_id;
        float grd_mt;
        float grd_hw;
        float grd_final;
        String grd_lgrade;
        
        public void set_grd_id(int id){
            this.grd_id=id;
        }
        public void set_std_id(int std_id){
            this.std_id=std_id;
        }
        public void set_crs_id(int crs_id){
            this.crs_id = crs_id;
        }
        public void set_grd_mt(float grd_mt){
            this.grd_mt = grd_mt;
        }
        public void set_grd_hw(float grd_hw){
            this.grd_hw = grd_hw;
        }
        public void set_grd_final(float grd_final){
            this.grd_final=grd_final;
        }
        public void set_grd_lgrade(String grd_lgrade){
            this.grd_lgrade=grd_lgrade;
        }
        public int get_grd_id(){
            return this.grd_id;
        }
        public int get_std_id(){
            return this.std_id;
        }
        public int get_crs_id(){
            return this.crs_id;
        }
        public float get_grd_mt(){
            return this.grd_mt;
        }
        public float get_grd_hw(){
            return this.grd_hw;
        }
        public float get_grd_final(){
            return this.grd_final;
        }
        public String get_grd_lgrade(){
            return this.grd_lgrade;
        }
        public static boolean isValidStudentAndCourse(int std_id, int crs_id, Connection conn) {
        try {
            // Check if the student exists
            String checkStudentSQL = "SELECT COUNT(*) FROM student WHERE std_id = ?";
            PreparedStatement checkStudentStmt = conn.prepareStatement(checkStudentSQL);
            checkStudentStmt.setInt(1, std_id);
            ResultSet studentResultSet = checkStudentStmt.executeQuery();

            if (studentResultSet.next() && studentResultSet.getInt(1) == 0) {
                System.out.println("Invalid student ID: " + std_id);
                return false;
            }

            // Check if the course exists
            String checkCourseSQL = "SELECT COUNT(*) FROM course WHERE crs_id = ?";
            PreparedStatement checkCourseStmt = conn.prepareStatement(checkCourseSQL);
            checkCourseStmt.setInt(1, crs_id);
            ResultSet courseResultSet = checkCourseStmt.executeQuery();

            if (courseResultSet.next() && courseResultSet.getInt(1) == 0) {
                System.out.println("Invalid course ID: " + crs_id);
                return false;
            }

            // If both student and course exist, return true
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        public static void add_grade(int std_id, int crs_id, float grd_mt, float grd_hw, float grd_final, 
                String grd_lgrade, Connection conn) {
        try {
            // Insert grade into the grade table
            String sql = "INSERT INTO Grades (std_id, crs_id, grd_mt, grd_hw, grd_final, grd_lgrade) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, std_id);
            stmt.setInt(2, crs_id);
            stmt.setFloat(3, grd_mt);
            stmt.setFloat(4, grd_hw);
            stmt.setFloat(5, grd_final);
            stmt.setString(6, grd_lgrade);
            if (isValidStudentAndCourse(std_id, crs_id, conn)) {
                  stmt.executeUpdate();
                  System.out.println("Grade added successfully for student ID " + std_id + " and course ID " + crs_id);
            }
            else{
                 System.out.println("Student Id " + std_id + " and course ID " + crs_id +" dont exist");
            }
        } catch (SQLException e) {
           if (e.getErrorCode() == 1062) { // MySQL error code for duplicate entry
                        System.out.println("Error: Grades for Student ID " + std_id +
                                           " in Course ID " + crs_id + " already exists.");
                } else {
                    e.printStackTrace();
                    System.out.println("Error while adding Grades: " + e.getMessage());}
                }
        }
    
        public static void edit_grade(int grd_id,int std_id, int crs_id, float grd_mt, float grd_hw, float grd_final,
                String grd_lgrade, Connection conn) {
        try {

            // Update grade in the grade table
            String sql = "UPDATE Grades SET grd_mt = ?, grd_hw = ?, grd_final = ?, grd_lgrade = ?"
                    + " WHERE std_id = ? AND crs_id = ? AND grd_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setFloat(1, grd_mt);
            stmt.setFloat(2, grd_hw);
            stmt.setFloat(3, grd_final);
            stmt.setString(4, grd_lgrade);
            stmt.setInt(5, std_id);
            stmt.setInt(6, crs_id);
            stmt.setInt(7, grd_id);
            if (isValidStudentAndCourse(std_id, crs_id, conn)) {
                 int rowsUpdated = stmt.executeUpdate();
                          if (rowsUpdated > 0) {
                            System.out.println("Grade updated successfully for student ID " + std_id +
                                    " and course ID " + crs_id);
                        } else {
                            System.out.println("No grade found to update for student ID " + std_id +
                                    " and course ID " + crs_id);
                        }
            }
            else{
                  System.out.println("Student Id " + std_id + " and course ID " + crs_id +" dont exist");
            }

        } catch (SQLException e) {
           if (e.getErrorCode() == 1062) { // MySQL error code for duplicate entry
                        System.out.println("Error: Grades for Student ID " + std_id +
                                           " in Course ID " + crs_id + " already exists.");
                } else {
                    e.printStackTrace();
                    System.out.println("Error while adding Grades: " + e.getMessage());}
                }
        }
    
        public static void listGradeById(int grd_Id, Connection conn) {
        String query = "SELECT * FROM Grades WHERE grd_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, grd_Id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Grade ID: " + rs.getInt("grd_id"));
                System.out.println("Student ID: " + rs.getInt("std_id"));
                System.out.println("Course ID: " + rs.getInt("crs_id"));
                System.out.println("Midterm Grade: " + rs.getFloat("grd_mt"));
                System.out.println("Homework Grade: " + rs.getFloat("grd_hw"));
                System.out.println("Final Grade: " + rs.getFloat("grd_final"));
                System.out.println("Letter Grade: " + rs.getString("grd_lgrade"));
            } else {
                System.out.println("Grade with ID " + grd_Id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while listing grade: " + e.getMessage());
        }
    }
        public static void listAllGrades(Connection conn) {
            String query = "SELECT * FROM Grades";
            try (PreparedStatement pstmt = conn.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {

                if (!rs.isBeforeFirst()) {
                    System.out.println("No grades available.");
                } else {
                    while (rs.next()) {
                        System.out.println("\nGrade ID: " + rs.getInt("grd_id"));
                        System.out.println("Student ID: " + rs.getInt("std_id"));
                        System.out.println("Course ID: " + rs.getInt("crs_id"));
                        System.out.println("Midterm Grade: " + rs.getFloat("grd_mt"));
                        System.out.println("Homework Grade: " + rs.getFloat("grd_hw"));
                        System.out.println("Final Grade: " + rs.getFloat("grd_final"));
                        System.out.println("Letter Grade: " + rs.getString("grd_lgrade"));
                        System.out.println("---------------------------");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while listing all grades: " + e.getMessage());
            }
        }
        public static void deleteGradeById(int grdId, Connection conn) {
            String query = "DELETE FROM Grades WHERE grd_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, grdId);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Grade with ID " + grdId + " deleted.");
                } else {
                    System.out.println("Grade with ID " + grdId + " not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while deleting grade: " + e.getMessage());
            }
        }
        public static void deleteAllGrades(Connection conn) {
            String query = "DELETE FROM Grades";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("All grades have been deleted.");
                } else {
                    System.out.println("No grades found to delete.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while deleting all grades: " + e.getMessage());
            }
        }
        public static void backupGrades(Connection conn) {
            String selectQuery = "SELECT * FROM Grades";
            String insertQuery = "INSERT IGNORE  INTO Grades_backup (grd_id, std_id, crs_id, grd_mt, grd_hw, grd_final, grd_lgrade) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectQuery);
                 PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

                while (rs.next()) {
                    pstmt.setInt(1, rs.getInt("grd_id"));
                    pstmt.setInt(2, rs.getInt("std_id"));
                    pstmt.setInt(3, rs.getInt("crs_id"));
                    pstmt.setFloat(4, rs.getFloat("grd_mt"));
                    pstmt.setFloat(5, rs.getFloat("grd_hw"));
                    pstmt.setFloat(6, rs.getFloat("grd_final"));
                    pstmt.setString(7, rs.getString("grd_lgrade"));
                    pstmt.executeUpdate();
                }

                System.out.println("Grades backed up to the backup table successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while backing up grades: " + e.getMessage());
            }
        }
        public static void restoreGrades(Connection conn) {
            String selectQuery = "SELECT * FROM Grades_backup";
            String insertQuery = "INSERT IGNORE INTO Grades (grd_id, std_id, crs_id, grd_mt, grd_hw, grd_final, grd_lgrade) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectQuery);
                 PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

                while (rs.next()) {
                    pstmt.setInt(1, rs.getInt("grd_id"));
                    pstmt.setInt(2, rs.getInt("std_id"));
                    pstmt.setInt(3, rs.getInt("crs_id"));
                    pstmt.setFloat(4, rs.getFloat("grd_mt"));
                    pstmt.setFloat(5, rs.getFloat("grd_hw"));
                    pstmt.setFloat(6, rs.getFloat("grd_final"));
                    pstmt.setString(7, rs.getString("grd_lgrade"));
                    pstmt.executeUpdate();
                }

                System.out.println("Grades restored from backup successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while restoring grades: " + e.getMessage());
            }
        }

    }

    public class Attendance{
        int att_id;
        int std_id;
        int crs_id;
        Date att_date;
        public void set_att_id(int id){
            this.att_id=id;
        }
        public void set_std_id(int std_id){
           this.std_id=std_id;
       }
        public void set_crs_id(int crs_id){
           this.crs_id=crs_id;
       }
        public void set_att_date(Date att_date){
       this.att_date=att_date;
       }     
        public int get_att_id(){
           return this.att_id;
       }
        public int get_std_id(){
           return this.std_id;
       }
        public int get_crs_id(){
           return this.crs_id;
       }
        public Date get_att_date(){
           return this.att_date;
       }
       
       public static boolean isValidStudentAndCourse(int std_id, int crs_id, Connection conn) {
            try {
                // Check if the student exists
                String checkStudentSQL = "SELECT COUNT(*) FROM student WHERE std_id = ?";
                PreparedStatement checkStudentStmt = conn.prepareStatement(checkStudentSQL);
                checkStudentStmt.setInt(1, std_id);
                ResultSet studentResultSet = checkStudentStmt.executeQuery();

                if (studentResultSet.next() && studentResultSet.getInt(1) == 0) {
                    System.out.println("Invalid student ID: " + std_id);
                    return false;
                }

                // Check if the course exists
                String checkCourseSQL = "SELECT COUNT(*) FROM course WHERE crs_id = ?";
                PreparedStatement checkCourseStmt = conn.prepareStatement(checkCourseSQL);
                checkCourseStmt.setInt(1, crs_id);
                ResultSet courseResultSet = checkCourseStmt.executeQuery();

                if (courseResultSet.next() && courseResultSet.getInt(1) == 0) {
                    System.out.println("Invalid course ID: " + crs_id);
                    return false;
                }

                // If both student and course exist, return true
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }              
        public static void addAttendance(int stdId, int crsId, Date attDate, Connection conn) {
            String insertQuery = "INSERT INTO Attendance (std_id, crs_id, att_date) VALUES (?, ?, ?)";

                try (
                        PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                    // Set the parameters for the PreparedStatement
                    pstmt.setInt(1, stdId);
                    pstmt.setInt(2, crsId);
                    pstmt.setDate(3, new java.sql.Date(attDate.getTime())); // Convert java.util.Date to java.sql.Date

                    // Execute the query to insert the attendance record
                   if(isValidStudentAndCourse(stdId,crsId,conn)){
                          pstmt.executeUpdate();
                          System.out.println("Attendance for Student ID " + stdId + " in Course ID " + crsId +
                                  " added successfully.");
                   }
                   else{
                          System.out.println("Student  " + stdId + " in Course ID " + crsId + " doesnt exist!");
                   }
                }

                catch (SQLException e) {
                    if (e.getErrorCode() == 1062) { // MySQL error code for duplicate entry
                        System.out.println("Error: Attendance for Student ID " + stdId +
                                           " in Course ID " + crsId + " on " + attDate +
                                           " already exists.");
                } else {
                    e.printStackTrace();
                    System.out.println("Error while adding attendance: " + e.getMessage());}
                }
            }
        
        public static void editAttendance(int attId, int stdId, int crsId, Date attDate, Connection conn) {
            String updateQuery = "UPDATE Attendance SET std_id = ?, crs_id = ?, att_date = ? WHERE att_id = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
                // Set the parameters for the PreparedStatement
                pstmt.setInt(1, stdId);
                pstmt.setInt(2, crsId);
                pstmt.setDate(3, new java.sql.Date(attDate.getTime())); // Convert java.util.Date to java.sql.Date
                pstmt.setInt(4, attId);

                // Execute the update query
                if(isValidStudentAndCourse(stdId,crsId,conn)){
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Attendance record with ID " + attId + " updated successfully.");
                } else {
                    System.out.println("Attendance record with ID " + attId + " not found.");
                }
                }
                 else{
                          System.out.println("Student  " + stdId + " in Course ID " + crsId + " doesnt exist!");
                   }

            }
            catch (SQLException e) {
                    if (e.getErrorCode() == 1062) { // MySQL error code for duplicate entry
                        System.out.println("Error: Attendance for Student ID " + stdId +
                                           " in Course ID " + crsId + " on " + attDate +
                                           " already exists.");
                } else {
                    e.printStackTrace();
                    System.out.println("Error while adding attendance: " + e.getMessage());}
                }
        }
        public static void listAttendanceById(int attId, Connection conn) {
    String query = "SELECT * FROM Attendance WHERE att_id = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, attId);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println("Attendance ID: " + rs.getInt("att_id"));
            System.out.println("Student ID: " + rs.getInt("std_id"));
            System.out.println("Course ID: " + rs.getInt("crs_id"));
            System.out.println("Attendance Date: " + rs.getDate("att_date"));
        } else {
            System.out.println("Attendance record with ID " + attId + " not found.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error while listing attendance: " + e.getMessage());
    }
}
        public static void listAllAttendance(Connection conn) {
    String query = "SELECT * FROM Attendance";
    try (PreparedStatement pstmt = conn.prepareStatement(query);
         ResultSet rs = pstmt.executeQuery()) {

        if (!rs.isBeforeFirst()) {
            System.out.println("No attendance records available.");
        } else {
            while (rs.next()) {
                System.out.println("Attendance ID: " + rs.getInt("att_id"));
                System.out.println("Student ID: " + rs.getInt("std_id"));
                System.out.println("Course ID: " + rs.getInt("crs_id"));
                System.out.println("Attendance Date: " + rs.getDate("att_date"));
                System.out.println("---------------------------");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error while listing all attendance records: " + e.getMessage());
    }
}
        public static void deleteAttendanceById(int attId, Connection conn) {
            String query = "DELETE FROM Attendance WHERE att_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, attId);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Attendance record with ID " + attId + " deleted.");
                } else {
                    System.out.println("Attendance record with ID " + attId + " not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while deleting attendance: " + e.getMessage());
            }
        }
        public static void deleteAllAttendance(Connection conn) {
            String query = "DELETE FROM Attendance";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("All attendance records have been deleted.");
                } else {
                    System.out.println("No attendance records found to delete.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while deleting all attendance records: " + e.getMessage());
            }
        }
        public static void backupAttendance(Connection conn) {
            String selectQuery = "SELECT * FROM Attendance";
            String insertQuery = "INSERT IGNORE  INTO Attendance_backup (att_id, std_id, crs_id, att_date) VALUES (?, ?, ?, ?)";

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectQuery);
                 PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

                while (rs.next()) {
                    pstmt.setInt(1, rs.getInt("att_id"));
                    pstmt.setInt(2, rs.getInt("std_id"));
                    pstmt.setInt(3, rs.getInt("crs_id"));
                    pstmt.setDate(4, rs.getDate("att_date"));
                    pstmt.executeUpdate();
                }

                System.out.println("Attendance records backed up to the backup table successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while backing up attendance records: " + e.getMessage());
            }
        }
        public static void restoreAttendance(Connection conn) {
            String selectQuery = "SELECT * FROM Attendance_backup";
            String insertQuery = "INSERT IGNORE INTO Attendance (att_id, std_id, crs_id, att_date) VALUES (?, ?, ?, ?)";

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectQuery);
                 PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

                while (rs.next()) {
                    pstmt.setInt(1, rs.getInt("att_id"));
                    pstmt.setInt(2, rs.getInt("std_id"));
                    pstmt.setInt(3, rs.getInt("crs_id"));
                    pstmt.setDate(4, rs.getDate("att_date"));
                    pstmt.executeUpdate();
                }

                System.out.println("Attendance records restored from backup successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while restoring attendance records: " + e.getMessage());
            }
        }

    }
}
    

