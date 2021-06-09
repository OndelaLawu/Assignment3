
package za.ac.cput;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Ondela Lawu 
 * Assignment 3
 * 214053857
 */
public class CreateSupplierMain {
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
     
         public void  writeToFile(List<Supplier>list, String file){
            try{
                output = new ObjectOutputStream(new FileOutputStream("stakeholder.ser"));
                for(Supplier ss : list){
                output.writeObject(ss);
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
        
        
       
     public List<Supplier>readFromFile(String file) {
        
       
       List<Supplier> lis =new ArrayList<>();
       ObjectInputStream in = null;
        
       
         try{
            in = new ObjectInputStream(new FileInputStream("stakeholder.ser"));
            while(true){
                Supplier supp = (Supplier) in.readObject();
                lis.add(supp);
            }
        }
          catch(EOFException eofException){
            return lis;
        }
        finally{
            try{
                if(in !=null)
                    in.close();
            }
            catch(IOException ioe){
              System.err.println("Error closing  file");
        }
          
          return lis;  
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
        
       
        String filepath = "C:\\Users\\simnikiwe\\Desktop\\Assignment3\\supplierOutFile.txt";
        
        List<Supplier> list =new ArrayList<Supplier>();
        list.add(new Supplier("S270", "Grand Theft Auto", "Toyota", "Mid-size sedan"));
        list.add(new Supplier("S400", "Prime Motors", "Lexus", "Luxury sedan"));
        list.add(new Supplier("S300", "We got Cars", "Toyota", "10-seater minibus"));
        list.add(new Supplier("S350", "Auto Delight", "BMW", "Luxury SUV"));
        list.add(new Supplier("S290", "MotorMania", "Hyundai", "compact budget"));
       
       
       
        CreateSupplierMain obj = new CreateSupplierMain();
        
        obj.writeToFile(list, filepath);
        List<Supplier> supp = obj.readFromFile(filepath);
        System.out.println("===========SUPPLIERS=============");
        System.out.printf("%-7s%-7s%-10s%-10s\n","ID","Name",
                "Prod Type", "Product Description");
        System.out.println("====================================================");
        SortCompare sr = new SortCompare();
       
        for (int i=0; i<list.size(); i++) 
        System.out.println(list.get(i)); 
        System.out.println("====================================================");
  
       
       
         
    }
      
    
    }
     
      
    

     
     
