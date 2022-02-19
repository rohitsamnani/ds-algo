package operators;

//10001 & 1 => if last binary digit is 1 then its old else its even, so just & with 1 and get odd even
public class OddEven {
	
	public static void main(String[] args) {
		//findout number is odd or even
		
		System.out.println(oddEvenFind(16));
	}

	private static String oddEvenFind(int num) {
		return (num & 1)==0?"Even":"Odd";
	}

}
