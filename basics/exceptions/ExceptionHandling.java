package exceptions;

import java.util.Arrays;

public class ExceptionHandling {

	public static void main(String[] args) {
		String s = null;
		int a=0;
		try {
			a = 2/0;
		}
		catch (ArithmeticException|NumberFormatException ex)
		{
		 System.out.println("Exception Encountered " + ex);
		 }
		finally {
			System.out.println("after exception came here");
		}
		System.out.println("outside catch");
		
		Arrays.asList(new CustomException(), new CustomException());
		
	}
}
