package example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Result1 {
    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
	public static int lcm_of_array_elements(int[] element_array)
    {
	 int lcm_of_array_elements = 1;
     int divisor = 2;
      
     while (true) {
         int counter = 0;
         boolean divisible = false;
          
         for (int i = 0; i < element_array.length; i++) {

             // lcm_of_array_elements (n1, n2, ... 0) = 0.
             // For negative number we convert into
             // positive and calculate lcm_of_array_elements.

             if (element_array[i] == 0) {
                 return 0;
             }
             else if (element_array[i] < 0) {
                 element_array[i] = element_array[i] * (-1);
             }
             if (element_array[i] == 1) {
                 counter++;
             }

             // Divide element_array by devisor if complete
             // division i.e. without remainder then replace
             // number with quotient; used for find next factor
             if (element_array[i] % divisor == 0) {
                 divisible = true;
                 element_array[i] = element_array[i] / divisor;
             }
         }

         // If divisor able to completely divide any number
         // from array multiply with lcm_of_array_elements
         // and store into lcm_of_array_elements and continue
         // to same divisor for next factor finding.
         // else increment divisor
         if (divisible) {
             lcm_of_array_elements = lcm_of_array_elements * divisor;
         }
         else {
             divisor++;
         }

         // Check if all element_array is 1 indicate
         // we found all factors and terminate while loop.
         if (counter == element_array.length) {
             return lcm_of_array_elements;
         }
     }
    }
	
    public static int getTotalX(List<Integer> a, List<Integer> b) {
    	int counter=0;
    	  int[] arr = new int[a.size()];
    	  
          // ArrayList to Array Conversion
          for (int i =0; i < a.size(); i++)
              arr[i] = a.get(i);
          
    	
    	int lcm = lcm_of_array_elements(arr);
    	int min=Collections.min(b);
    	
    	for(int i=lcm;i<=min;i+=lcm) {
    		int tempCount=0;
    		for(int j=0;j<b.size();j++) {
    			if(b.get(j)%i==0) {
    				tempCount++;
    			}
    		}
    		if(tempCount==b.size())
    			counter++;
    	}
    	return counter;
    	

    }

}

public class Solutions1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        int total = Result1.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
