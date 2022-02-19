package array;

	import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

	class Result {

	    /*
	     * Complete the 'maximumSum' function below.
	     *
	     * The function is expected to return a LONG_INTEGER.
	     * The function accepts following parameters:
	     *  1. LONG_INTEGER_ARRAY a
	     *  2. LONG_INTEGER m
	     */

	    public static long maximumSum(List<Long> a, long m) {
	    	Integer[] arr=a.stream().toArray(Integer[]::new);
	    	int length=arr.length;
	    	double total=length * ((length+1)/1);
	    	int result=Integer.MIN_VALUE;
	    	
	    	for(int i=0;i<length;i++) {
	    		for(int j=0;j<=i;j++) {
	    		
	    		}
	    	}
	    	return 0;

	    }

	}

	public class MaxNumberAfterModuloOfSubArray {
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

	        int q = Integer.parseInt(bufferedReader.readLine().trim());

	        IntStream.range(0, q).forEach(qItr -> {
	            try {
	                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	                int n = Integer.parseInt(firstMultipleInput[0]);

	                long m = Long.parseLong(firstMultipleInput[1]);

	                List<Long> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	                    .map(Long::parseLong)
	                    .collect(toList());

	                long result = Result.maximumSum(a, m);

	                bufferedWriter.write(String.valueOf(result));
	                bufferedWriter.newLine();
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        });

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
	}
