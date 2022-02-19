package example;

public class ElementOfSequence {
	
	public static void main(String[] args) {
		int[] arr = {471813116,347152398,194618530,683701551,777767296,111883749,546453905,781722554,209904752,115839007,421793187,698987773};
		System.out.println(findPairwithSameSum(arr));
		int i=10;
		String num= Integer.toString(i);
	}

	private static String findPairwithSameSum(int[] arr) {
		long result=0;
		for(int i=0;i<arr.length;i++) {
				result=Math.abs(result-arr[i]);
		}

		return result==0?"YES":"No";
	}

}
