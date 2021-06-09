
package za.ac.cput;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Ondela Lawu
 * Assignment 3 
 * 214053857
 */
public class CreateStakeholderSerMain {
     
      ObjectOutputStream output;
    
    
        public void openFile(){
        try{
            output = new ObjectOutputStream( new FileOutputStream( "stakeholder.ser" ) ); 
            System.out.println("*** ser file created and opened for writing ***");               
        }
        catch (IOException ioe){
            System.out.println("error opening ser file: " + ioe.getMessage());
            System.exit(1);
        }
    }
        public void  writeToFile(List<Customer>list, String file){
            try{
                output = new ObjectOutputStream(new FileOutputStream("stakeholder.ser"));
                for(Customer c : list){
                output.writeObject(c);
                    System.out.printf("********written to ser file**********\n:");
                    
                }
            }
            catch(IOException ioe){
                System.out.println("Error"+ ioe);
            }
            finally{
                closeFile();
                System.out.println("file closed");
            }
        }
        
    
    
    public List<Customer>readFromFile(String file) {
        
       
       List<Customer> li =new ArrayList<>();
       ObjectInputStream in = null;
        
       
         try{
            in = new ObjectInputStream(new FileInputStream("stakeholder.ser"));
            while(true){
                Customer p = (Customer) in.readObject();
                li.add(p);
            }
        }
          catch(EOFException eofException){
            return li;
        }
        finally{
            try{
                if(in !=null)
                    in.close();
            }
            catch(IOException ioe){
              System.err.println("Error closing  file");
        }
         
         
          
          return li;  
        }
        
        
      
    }
        
    public void closeFile(){
        try{
        output.close( ); 
        }
        catch (IOException ioe){            
            System.out.println("error closing ser file: " + ioe.getMessage());
            System.exit(1);
          
    }
  }
    
     public static void main(String args[]) throws ClassNotFoundException, IOException  {
        
        String filepath = "C:\\Users\\simnikiwe\\Desktop\\Assignment3\\customerOutFile.txt";
        
        List<Customer> list =new ArrayList<Customer>();
        list.add(new Customer("C150", "Luke", "Atmyass", "Bellville", "1981-01-27", 1520.50, false));
        list.add(new Customer("C130", "Stu", "Padassol", "Sea Point", "1987-05-18", 645.25, true));
        list.add(new Customer("C100", "Mike", "Rohsopht", "Bellville", "1993-01-24", 975.10, true));
        list.add(new Customer("C300", "Ivana.B", "Withew", "Langa", "1998-07-16", 1190.50, false));
        list.add(new Customer("C250", "Eileen", "Sideways", "Nyanga", "1999-11-27", 190.85, true));
        list.add(new Customer("C260", "Ima", "Stewpidas", "Atlantis", "2001-01-27", 1890.70, true));
        
       
        
      
        CreateStakeholderSerMain obj = new CreateStakeholderSerMain();
        obj.writeToFile(list, filepath);
        List<Customer> c = obj.readFromFile(filepath);
        System.out.println("===========CUSTOMERS=============");
        System.out.printf("%-7s%-7s%-10s%-10s\n","ID","Name",
                "Surname", "Date of birth", "Age");
        
        for(Customer p : list ){
            System.out.printf("%-7s%-7s%-10s%-10s\n",p.getStHolderId(),p.getFirstName(),
                    p.getSurName(),p.getDateOfBirth());
            
        }
        int count=0;
        count++;
         System.out.println(" ");
         System.out.println("Number of customers who can rent:"+count);
         System.out.println("Number of customers who can not rent:"+count);
    }
}
     
      




