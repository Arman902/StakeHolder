/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Armand Nziza (217035019)
 */

    

import java.sql.*;

public class MyDB {
    
    private Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    
    String col1 = "customerNumber";
    String col2 = "firstName";
    String col3 = "surName";
    String col4 = "dateOfBirth";
    String col5 = "address";
    String col6 = "credit";
    String col7 = "canRent";

    
    public Connection connect(){
        try{
            //connect to the publisher.mdb database
        System.out.println("Creating connection...");
        String URL = "jdbc:ucanaccess://C:\\Users\\217301827\\Documents\\NetBeansProjects\\Ebenezer_217301827\\publisher.mdb";
        conn = DriverManager.getConnection(URL);
        System.out.println("Connection successfull");
        }
        catch(Exception ex){
            ex.getMessage();
        }
        return conn; 
    }

    public void init(){
        try{
            connect();
            //create CUSTOMER table
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.println("Statement created successfully");
            
            System.out.println("Executing create statement...");
            String create_statement = "create table CUSTOMER ("+col1+" INTEGER, "+col2+" TEXT, "+col3+" TEXT, "+col4+" TEXT, "+col5+" TEXT, " +col6+" FLOAT, "+col7+" BOOLEAN)";
            //System.out.println(create_statement);
            stmt.executeUpdate(create_statement);
            System.out.println("Statement executed successfully");
            
        }
        catch(Exception ex){
            ex.getMessage();
        }
        
    }       //end init()
    
    
    public void populateDB(int custNumber, String firstName, String surName, String dob, String addr, double cred, boolean canRent){
        try{
            System.out.println("Creating insert prepared statement...");
            String insert_values = "insert into CUSTOMER ("+col1+", "+col2+", "+col3+", "+col4+", "+col5+", " +col6+", "+col7+") values(?,?,?,?,?,?,?)";
            System.out.println("About to insert values...");
            pstmt = conn.prepareStatement(insert_values);
            System.out.println("Insert PStatement created successfully");
            pstmt.setInt(1, custNumber);
            pstmt.setString(2, firstName);
            pstmt.setString(3, surName);
            pstmt.setString(4, dob);
            pstmt.setString(5, addr);
            pstmt.setDouble(6, cred);
            pstmt.setBoolean(7, canRent);
            
            System.out.println("Executing insert pStatement...");
            pstmt.executeUpdate();
            System.out.println(" insert statement executed successfully");
        }
        catch(Exception ex){
            ex.getMessage();
        }
    }      //end populateDB
    
    
    public void fromDbToFile(){
        WriteToFile writing = new WriteToFile();
        
        try{
            System.out.println("executing Select Statement...");
            String read_from_db = "SELECT * FROM CUSTOMER";
            stmt = connect().createStatement();
            ResultSet rs = stmt.executeQuery(read_from_db);
            System.out.println("Select executed successfully");
            
            String message = String.format("%-15s\t%-15s\t%-20s\t%-15s\t%s\t%-15s", "Name", "Surname", "Age","Address", "Credit", "CanRent");
            writing.write(message+"\r\n");
            message = String.format("%-15s\t%-15s\t%-20s\t%-15s\t%s\t%-15s", "-----", "---------", "----","-----", "------", "-------");
            writing.write(message+"\r\n");
            
            int under40 = 0;
            int over40 = 0;
            int totCust = 0;
            
            while(rs.next()){
                Customer cus = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getBoolean(7));
                writing.write(""+cus.toString());
                
                if(cus.determineAge(rs.getString(4))>=40){
                    over40++;
                }
                else{
                    under40++;
                }
                
            }       //end while
            
            writing.write("\r\nNum customers under 40: \r\t"+under40+"\r\tPercent: "+under40/totCust+"\r\n");
            writing.write("Num customers 40 yrs plus 40: \r\t"+over40+"\r\tPercent: "+over40/totCust+"\r\n");

            writing.close();
        }
        catch(Exception ex){
            ex.getMessage();
        }
    
    }        //end fromDbToFile
    
    
    public void close(){
        try{
            conn.close();
            stmt.close();
        }
        catch(Exception ex){
            ex.getMessage();
        }
    }       //end close
    
    
    
    
}       //end class

    
}
