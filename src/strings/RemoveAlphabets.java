package strings;

public class RemoveAlphabets {

	public static void main(String[] args) {
		System.out.println(removeAlphabetsFromString("rohit samnani"));
	}

	private static String removeAlphabetsFromString(String s) {
		StringBuilder sb = new StringBuilder();
		
		for(int i =0;i<s.length();i++) {
			if(s.charAt(i)!='i') {
				sb.append(s.charAt(i));
			}
		}
		String s1 = new String(sb);
		return s1;
	}

}
