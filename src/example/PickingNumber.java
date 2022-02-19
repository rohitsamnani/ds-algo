package example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PickingNumber {
	
		 public static void main(String[] args) throws IOException {
		        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

		        int n = Integer.parseInt(bufferedReader.readLine().trim());

		        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		        int result = pickingNumbersWithHashMap(a);

		        bufferedWriter.write(String.valueOf(result));
		        bufferedWriter.newLine();

		        bufferedReader.close();
		        bufferedWriter.close();
		    }
	
	public static int pickingNumbers(List<Integer> a) {
		int max= Integer.MIN_VALUE;
		
		Integer arr[]= a.stream().toArray(Integer[]::new);
		
		int frequency[]= new int[100];
		
		for(int i=0;i<arr.length;i++) {
			frequency[arr[i]]++;
		}
		
		for(int i=0;i<frequency.length-1;i++) {
			if(frequency[i]+frequency[i+1]>max) {
				max=frequency[i]+frequency[i+1];
			}
		}
		return max;
	    }
	
	
	public static int pickingNumbersWithHashMap(List<Integer> a) {
		int max= Integer.MIN_VALUE;
		
		Integer arr[]= a.stream().toArray(Integer[]::new);
		
		Map<Integer,Integer> map= new HashMap<>();
		for(int i=0;i<arr.length;i++) {
		if(map.get(arr[i])==null)
			map.put(arr[i], 1);
		else {
			map.put(arr[i], (map.get(arr[i]))+1);
		}
		}
		int previousValue =0;
		for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
			
			if(previousValue+entry.getValue()>max)
				max=previousValue + entry.getValue();
			previousValue=entry.getValue();
		}
		
		return max;
	    }
}