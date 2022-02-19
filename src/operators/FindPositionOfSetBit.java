package operators;

public class FindPositionOfSetBit {

	public static void main(String[] args) {
		System.out.println(findPositionOfRightMostSetBit(100));
	}

	private static int findPositionOfRightMostSetBit(int num) {
		int position = 1;
		while ((num & 1) == 0) {
			num = num >> 1;
			position++;
		}
		System.out.println("position will be "+position + " and  its value will be "+(int)Math.pow(2, position-1));
		return position;
	}

}
