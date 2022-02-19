package operators;

//find out if a given num is power of 2 or not
public class NumIsPowerOfTwo {

	public static void main(String[] args) {
		int number = 256;
		System.out.println(firstWay(number));
		
		System.out.println(otherWay(number));
	
	}

	private static String otherWay(int number) {
		if(number==0) {
			return "No";
		}
		number=number & number-1;
		if(number==0)
			return "Yes";
		else
			return "No";
	}

	private static String firstWay(int number) {
		int counter = 0;
		while (number > 0) {
			if ((number & 1)==1) {
				counter++;
			}
			number=number>>1;
		}
		if(counter==1) {
		return "Yes";
		}
		else {
			return "No";
		}
	}
}
