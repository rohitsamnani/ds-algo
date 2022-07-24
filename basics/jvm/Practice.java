package jvm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Practice {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			int Q = Integer.parseInt(br.readLine().trim());
			String[] arr_type = br.readLine().split(" ");
			int[] type = new int[Q];
			for (int i_type = 0; i_type < arr_type.length; i_type++) {
				type[i_type] = Integer.parseInt(arr_type[i_type]);
			}
			String[] arr_X = br.readLine().split(" ");
			int[] X = new int[Q];
			for (int i_X = 0; i_X < arr_X.length; i_X++) {
				X[i_X] = Integer.parseInt(arr_X[i_X]);
			}

			long[] out_ = solve(Q, type, X);
			System.out.print(out_[0]);
			for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
				System.out.print(" " + out_[i_out_]);
			}

			System.out.println();

		}

		wr.close();
		br.close();
	}

	static long[] solve(int Q, int[] type, int[] X) {
		/*
		 * Q: Number of queries type: array denoting the type of each query X: array
		 * denoting parameter of each query
		 */

		
		List<Long> result1 = new ArrayList<>();
		
		List<Integer> arr =  new ArrayList<>();
		//int[] arr = new int[X.length];
			for (int t=0 ;t<type.length;t++) {
			switch (type[t]) {
			case 1:
				arr.add(X[t]);
				break;
			case 2:
				arr=removeElements(X[t],arr);
				break;
			case 3:
				result1.add(performXOR(X[t],arr));
				break;
			}
		}
		
		long[] result = new long[result1.size()];
		for(int i=0;i<result1.size();i++) {
			result[i]=result1.get(i);
		}
		return result;

	}

	private static Long performXOR(int i, List<Integer> arr) {
		long sum=0;
		for(int j:arr) {
			sum+=i^j;
		}
		return sum;
	}

	private static List<Integer> removeElements(int i, List<Integer> arr) {
		
		return arr.stream().filter(x->x!=i).collect(Collectors.toList());
	}
}