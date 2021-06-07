/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KISO
 */
    import java.io.*;
import java.util.Calendar;
import java.util.StringTokenizer;
public class Customer implements Serializable
public class Customer {

{
    private int custNumber;
    private String firstName;
    private String surName;
    private String address;
    private String dateOfBirth;
    private double credit;
    private boolean canRent;   


    public Customer()    {

    }

    public Customer(int custNumber, String firstName, String surName, String dob, String addr, double cred, boolean canRent)    {
    	setCustNumber(custNumber);
        setFirstName(firstName);
        setSurName(surName);
        setAddress(addr);
        setCredit(cred);
        setCanRent(canRent);
        setDateOfBirth(dob);
    }

    public void setCustNumber(int custNumber)  {
    	this.custNumber = custNumber;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setSurName(String surName)   {
        this.surName = surName;
    }

    public void setAddress(String addr)    {
        this.address = addr;
    }
    
    public void setDateOfBirth(String dob)    {
        this.dateOfBirth = dob;
    }
    
    public void setCredit(double cred)    {
        this.credit = cred;
    }
	
    public void setCanRent(boolean canRent)  {
		this.canRent = canRent;
    }

    public int getCustNumber()  {
    	return custNumber;
    }
    
    public String getFirstName()     {
        return firstName;
    }

    public String getSurName()    {
        return surName;
    }

    public String getAddress()    {
        return address;
    }
    
    public String getDateOfBirth()    {
        return dateOfBirth;
    }
    public double getCredit()    {
        return credit;
    }

    public boolean getCanRent()     {
        return canRent;
    }
        
    public int determineAge(String birthDate){
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
       
        StringTokenizer token = new StringTokenizer(birthDate, "-");
        
        String monthBirth = token.nextToken();
        int dayBirth = Integer.parseInt(token.nextToken());
        int yearBirth = Integer.parseInt(token.nextToken());
    
        return year-yearBirth;
    }     //end determineAge()
    

    public String toString()      {
        return String.format("%-15s\t%-15s\t%-20s\t%-15s\t%.2f\t%-15s", getFirstName(), getSurName(),
                determineAge(getDateOfBirth()), getAddress(), getCredit(), new Boolean(getCanRent()).toString());
    }   
}
    
}
