package example;

@FunctionalInterface
interface DefaultPractice1 {
	// A simple program to Test Interface default
	// methods in java
	
	    // abstract method
	    public int square(int a);
	  
	    // default method
	    default void show()
	    {
	      System.out.println("Default Method Executed");
	    }
	    default void show2()
	    {
	      System.out.println("Default Method Executed");
	    }
	}
	  
	public class DefaultPractice 
	{
	  
	    public static void main(String args[])
	    {
        
	    	DefaultPractice1 dp1 = (x)-> {int k = (x*x);
	    	return k;};
	    	dp1.square(4);
	  
	        // default method executed
	        
	    }
	}	
