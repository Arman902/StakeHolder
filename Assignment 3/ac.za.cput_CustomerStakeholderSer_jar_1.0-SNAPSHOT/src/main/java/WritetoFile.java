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
public class WritetoFile {
 


public class WriteToFile {
        
    MyDB myDB = new MyDB();     //instance of our database
    
    BufferedWriter bw;
    
    public void open(){
        
        try{
            bw = new BufferedWriter(new FileWriter("Assignment3Out.txt"));
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
    }        //end open()
    
    public void write(String message){
                
        try{
            System.out.println("Writing to file...");
            bw.write(message+"\r\n");
            System.out.println("Writing successfull...");
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
    }        //end process()
    
    
    public void close(){
        try {
            bw.close();
        } 
        catch (IOException ioe) {
            ioe.getMessage();
        }
    }        //end close()
    
    
    
}

    
}
