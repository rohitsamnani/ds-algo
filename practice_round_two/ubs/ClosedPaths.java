package ubs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Result {

	/*
	 * Complete the 'closedPaths' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts INTEGER
	 * number as parameter.
	 */

	static int closedPaths = 0;

	public static int closedPaths(int number) {

		// Map tp hold the pclosed path disit and distance

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		map.put(4, 1);
		map.put(6, 1);
		map.put(9, 1);
		map.put(8, 2);

		while (number > 0) {

			int reminder = number % 10;
			if (map.get(reminder) != null) {
				closedPaths = closedPaths + map.get(reminder);
			}
			number = number / 10;

		}

		return closedPaths;
	}

}

public class ClosedPaths {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int number = Integer.parseInt(bufferedReader.readLine().trim());

		int result = Result.closedPaths(number);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}