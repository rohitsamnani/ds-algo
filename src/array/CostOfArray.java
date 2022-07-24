package array;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

class Result1011 {

	/*
	 * Complete the 'getMinimumCost' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * INTEGER_ARRAY arr as parameter.
	 */
	static Long minimumCost = Long.MAX_VALUE;

	public static long getMinimumCost(List<Integer> arr) {
		
		int length = arr.size()-1;
		int index = 0;
		int removalIndex = -1;
		while (length > index) {
			Long currentCost = 0L;
			for (int i = 0; i < arr.size() - 1; i++) {
				currentCost = currentCost + ((arr.get(i) - arr.get(i + 1)) * (arr.get(i) - arr.get(i + 1)));
			}
			if (minimumCost > currentCost) {
				minimumCost = currentCost;
			}
			if(removalIndex!=-1) {
				arr.remove(removalIndex);
			}
			int value = (arr.get(index) + arr.get(index + 1)) / 2;
			removalIndex = index + 1;
			arr.add(removalIndex, value);
			index = index + 1;
		}

		return minimumCost;
	}

}

public class CostOfArray {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

		int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		long result = Result1011.getMinimumCost(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
