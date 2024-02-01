/*
 * BSTReplicated.java
 * 
 */

import java.io.File;
import java.io.IOException;


public class BSTReplicated  {
 
    public static void main(String s[]) 
    {
    	
		//Students create 2 BinarySearchInt objects.
    	
    		// a) Uses the default constructor
    	BinarySearchIntTree test1 = new BinarySearchIntTree();
    		// b) Uses the the construtor that allows an integer value to be passed in.
    	BinarySearchIntTree test2 = new BinarySearchIntTree(10);
    	
		
      	//Test out each of your various methods (getSize, clear, isEmpty, add, findParent, contains, remove, toString)) 
      		//using either of the instantiated BinarySearchIntTree objects
    	System.out.println(test1.getSize());
    	test1.clear();
    	System.out.println("Adding values to Tree:");
		int[] data = {17, 12, 35, 4, 15, 22, 58, -2, 7, 13, 16, 19, 31, 40, 87};
		for(int i = 0; i < data.length; i++)
		{
			System.out.printf("\tAdding %d: ", data[i]);
			try{System.out.println(test1.add(data[i]) ? "Successful": "FAILED - returned false");}catch(Exception e){System.out.println("FAILED - Got "+e);}
		}
    	System.out.println(test2.isEmpty());
    	System.out.println(test2.contains(4));
    	System.out.println(test2.remove(4));
    	System.out.println(test2.toString());
    	
    	System.out.println(test2.getSize());
    	test2.clear();
    	System.out.println("Adding values to Tree:");
		int[] data2 = {17, 12, 35, 4, 15, 22, 58, -2, 7, 13, 16, 19, 31, 40, 87};
		for(int i = 0; i < data.length; i++)
		{
			System.out.printf("\tAdding %d: ", data2[i]);
			try{System.out.println(test2.add(data2[i]) ? "Successful": "FAILED - returned false");}catch(Exception e){System.out.println("FAILED - Got "+e);}
		}
    	System.out.println(test2.isEmpty());
    	System.out.println(test2.contains(4));
    	System.out.println(test2.remove(4));
    	System.out.println(test2.toString());
		
    	
      		
    }
    
	//Create your BinarySearchIntTree class in another file called "BinarySearchIntTree"
}
