package example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Result {
public static int saveThePrisoner(int n, int m, int s) {
	return ((m-1)%n+1)+((n+s)%n+1);
}
}

public class Solution {
	
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

	        int t = Integer.parseInt(bufferedReader.readLine().trim());

	        IntStream.range(0, t).forEach(tItr -> {
	            try {
	                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	                int n = Integer.parseInt(firstMultipleInput[0]);

	                int m = Integer.parseInt(firstMultipleInput[1]);

	                int s = Integer.parseInt(firstMultipleInput[2]);

	                int result = Result.saveThePrisoner(n, m, s);

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