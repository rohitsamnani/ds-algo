package strings;

//You can use Stack for reverse String, use Stack package for the same
public class ReverseString {

	public static void main(String[] args) {
		String s = "RohitSamnani";
		System.out.println(s);
		System.out.println(reverseString(s));
		System.out.println(s);
		System.out.println(recursiveReverse(s));
	}

	private static String reverseString(String s) {

		String rstr="";
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			rstr=c+rstr;
		}
		return rstr;
	}
	
	private static String recursiveReverse(String s) {
		if(s.length()==1) {
			return s;
		}
		return recursiveReverse(s.substring(1))+s.charAt(0);
	}
}
