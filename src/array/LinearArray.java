package array;

import java.util.Arrays;

public class LinearArray {
	
	public static void main(String[] args) {
		String s ="Anaya";
		System.out.println(checkChar(s, 'y'));
		System.out.println(checkChar1(s, 'y'));
		
		System.out.println(s);
		System.out.println(s.toCharArray());
		System.out.println(Arrays.toString(s.toCharArray()));
	}
	
	static boolean checkChar(String s, char target) {
		if(s.length()==0) {
			return false;
		}
		for(int index=0;index<s.length();index++) {
			if(s.charAt(index)==target) {
				return true;
			}
		}
		return false;
	}
	
	static boolean checkChar1(String s, char target) {
		if(s.length()==0) {
			return false;
		}
		for(char c : s.toCharArray()) {
			if(c==target) {
				return true;
			}
		}
		return false;
	}
}
