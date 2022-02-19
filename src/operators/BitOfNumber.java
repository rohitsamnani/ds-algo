package operators;

//find ith Bit of number , answer is do left shift with n-1 and do & return accordingly
//set the ith bit , answer is do left shift with n-1 and do ||, its done
//reset the ith bit, answer is do left shift with n-1 and make it opposite,after that do &, its done
public class BitOfNumber {

	public static void main(String[] args) {
		int number = 101;
		int bit = 5;

		//output will be 0
		System.out.println(findValueOfIthBit1(number, bit));
		number = setIthBit(number, bit);
		
		//set 5th bit as 1
		System.out.println(findValueOfIthBit1(number, bit));
		//set done output will be 1
		System.out.println(number);
		
		//reset 5th bit
		number= resetIthBit(number, bit);
		//reset done, 5th bit output will be 0 again
		System.out.println(findValueOfIthBit1(number, bit));
		System.out.println(number);

		
	}

	private static int resetIthBit(int number, int bit) {
		
		int op = ~(1<<(bit-1));

		return number & op; 
	}

	private static int setIthBit(int num, int bit) {

		return num | (1 << bit - 1);

	}

	private static int findValueOfIthBit1(int num, int bit) {
		int andWith = 1 << (bit - 1);
		return (num & andWith) == andWith ? 1 : 0;

	}

	private static int findValueOfIthBit(int num, int bit) {
		int andWith = (int) Math.pow(2, (bit - 1));
		return (num & andWith) == andWith ? 1 : 0;

	}

}
