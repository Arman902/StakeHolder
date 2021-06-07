/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KISO
 */
 import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;
import java.util.StringTokenizer;
 
 
public class ReadSer {
    ObjectInputStream input;
    
    MyDB myDB = new MyDB();     //instance of our database
    
    public void open(){
        myDB.init();        //initialize our database
        
        try{
            input = new ObjectInputStream(new FileInputStream("customer.ser"));
        }
        catch(FileNotFoundException fnfe){
            fnfe.getMessage();
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
    }        //end open()
    
    public void process(){
        
        try{
            while(true){
                System.out.println("about to read object from ser file");
                Customer cust = (Customer) input.readObject();
                System.out.println("Reatrieved customer object");
                //populate our database
                myDB.populateDB(cust.getCustNumber(), cust.getFirstName(), cust.getSurName(), cust.getDateOfBirth(), cust.getAddress(), cust.getCredit(), cust.getCanRent());
            }       //end while
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
        catch(ClassNotFoundException cnfe){
            cnfe.getMessage();
        }
    }        //end process()

    
    
    public void close(){
        try {
            input.close();        
            myDB.close();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
    }        //end close()
    
    
}       //end class

    

