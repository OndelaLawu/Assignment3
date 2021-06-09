
package za.ac.cput;

import java.util.Comparator;

/**
 *
 * @author Ondela Lawu
 * Assignment 3
 * 214053857
 */
public class SortCompare implements Comparator<Customer>{
   
       

    @Override
    public int compare(Customer o1, Customer o2) {
      return o1.getStHolderId().compareTo(o2.getStHolderId());
    }
}
