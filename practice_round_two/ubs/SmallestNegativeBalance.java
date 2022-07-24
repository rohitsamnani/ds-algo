package ubs;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result1 {

	/*
	 * Complete the 'smallestNegativeBalance' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * 2D_STRING_ARRAY debts as parameter.
	 */

	public static List<String> smallestNegativeBalance(List<List<String>> debts) {

		Map<String, Integer> map = new HashMap<>();
		List<String> result = new ArrayList<>();

		for (int i = 0; i < debts.size(); i++) {

			List<String> names = debts.get(i);
			int temp = Integer.valueOf(names.get(2));

			// for Borrower
			if (map.get(names.get(0)) == null) {
				map.put(names.get(0), -temp);
			} else {
				map.put(names.get(0), map.get(names.get(0)) - temp);
			}

			// For lender
			if (map.get(names.get(1)) == null) {
				map.put(names.get(1), temp);
			} else {
				map.put(names.get(1), map.get(names.get(1)) + temp);
			}
		}
		map.forEach((k, v) -> {
			if (map.get(k) < 0) {
				result.add(k);
			}
		});
		
		Comparator<Entry<String, Integer>> comparator1 =	(e1,e2)->  {
			if(e1.getValue()==e2.getValue()) {
				return e1.getKey().compareTo(e2.getKey());
			}
			return e1.getValue()-e2.getValue();
		};
		
		map.entrySet().stream().sorted(comparator1).forEach(k -> result.add(k.getKey()));


		if (result.size() == 0) {
			result.add("Nobody has a negative balance");
		}

		return result;

	}

}

public class SmallestNegativeBalance {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int debtsRows = Integer.parseInt(bufferedReader.readLine().trim());
		int debtsColumns = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<String>> debts = new ArrayList<>();

		IntStream.range(0, debtsRows).forEach(i -> {
			try {
				debts.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<String> result = Result1.smallestNegativeBalance(debts);

		bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
