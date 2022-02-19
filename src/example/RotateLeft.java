package example;

	import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

	class Result7 {

	    /*
	     * Complete the 'rotLeft' function below.
	     *
	     * The function is expected to return an INTEGER_ARRAY.
	     * The function accepts following parameters:
	     *  1. INTEGER_ARRAY a
	     *  2. INTEGER d
	     */

	    public static List<Integer> rotLeft(List<Integer> a, int d) {
	        rotLeft(a,0,d-1);
	        rotLeft(a,d,a.size()-1);
	        rotLeft(a,0,a.size()-1);
	        return a;

	    }
	    
	    public static void rotLeft(List<Integer> a,int start, int end){
	        while(start<end){
	          Integer temp=a.get(end);
	          a.add(end,a.get(start));
	          a.remove(end);
	          
	          a.remove(start);
	          a.add(start, temp);
	          
	            start++;
	            end--;
	        }
	    }

	}

	public class RotateLeft {
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

	        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	        int n = Integer.parseInt(firstMultipleInput[0]);

	        int d = Integer.parseInt(firstMultipleInput[1]);

	        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	            .map(Integer::parseInt)
	            .collect(toList());

	        List<Integer> result = Result7.rotLeft(a, d);

	        bufferedWriter.write(
	            result.stream()
	                .map(Object::toString)
	                .collect(joining(" "))
	            + "\n"
	        );

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
	}

