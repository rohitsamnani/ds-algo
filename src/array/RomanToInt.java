package array;

public class RomanToInt {

	public int value(char c) {

		if (c == 'I') {
			return 1;
		}
		if (c == 'V') {
			return 5;
		}
		if (c == 'X') {
			return 10;
		}
		if (c == 'L') {
			return 50;
		}
		if (c == 'C') {
			return 100;
		}
		if (c == 'D') {
			return 500;
		}
		if (c == 'M') {
			return 1000;
		}
		return -1;
	}

	public int romanToInt(String s) {
		
		int num=0;
		for (int i = 0; i < s.length(); i++) {
			int s1 = this.value(s.charAt(i));
			if (i + 1 < s.length()) {
				int s2 = this.value(s.charAt(i + 1));
				if(s1>=s2) {
					num=num+s1;
				}
				else {
				num=num+s2-s1;	
				i++;
				}
			}
			else {
				num=num+s1;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
	}

}
