/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Armand Nziza
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Nziza_217035019 {


    public static void main(String[] args) {
        Customer cust;
    	try
        {
           ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("customer.ser"));
           output.writeObject(new Customer(100, "Luke", "Atmyass", "December-31-1970", "Bellville", 1520, false));
           output.writeObject(new Customer(200, "Al", "Kaholic", "November-14-1985", "Welgemoed", 850, true));
           output.writeObject(new Customer(300, "Stu", "Padassol", "September-25-1997", "Sea Point", 645, true));
           output.writeObject(new Customer(400, "Juju", "Magadla", "April-4-1999", "Gugulethu", 1260, true));
           output.writeObject(new Customer(500, "Isabelle", "Ringing", "January-11-1979", "Manenberg", 1040, true));
           output.writeObject(new Customer(600, "Mike", "Rohsopht", "March-16-1992", "Bellville", 975, true));
           output.writeObject(new Customer(700, "Ivana.B", "Withew", "December-12-1990", "Langa", 1190, false));
           output.writeObject(new Customer(800, "Dane", "Geruss", "June-29-1977", "Athlone", 690, true));
           output.writeObject(new Customer(900, "Marsha", "Mellow", "November-3-1980", "Constantia", 1990, false));
           output.writeObject(new Customer(1000, "Eileen", "Sideways", "August-13-1976", "Nyanga", 190, true));
           output.writeObject(new Customer(1100, "Ima", "Stewpidas", "July-21-1995", "Atlantis", 1890, false));
           output.close();
        }//end try       
        catch(IOException fnfe )
        {
            System.out.println(fnfe);
            System.exit(1);
        }
    
        ReadSer read = new ReadSer();
        MyDB myDb = new MyDB();
        
        read.open();
        read.process();
        
        myDb.fromDbToFile();
        
        read.close();
        
    }//end main
    
}       //end class

    
}
