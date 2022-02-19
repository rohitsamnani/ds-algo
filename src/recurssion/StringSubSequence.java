package recurssion;

import java.util.ArrayList;

//used in permutation and combinations
//SubSets: non-adjencent collection

//apply subset pattern: taking some elements and removing some elements from array called subsets
//which one to take and which one to remove can be seen in below program

public class StringSubSequence {
	static ArrayList<String> al = new ArrayList<String>();

	public static void main(String[] args) {
		String un = "abc";
		subSequence("", un);
		System.out.println(al);
		System.out.println(subSequence1("", un, new ArrayList<String>()));
		System.out.println(subSequence2("", un));
		System.out.println(al.size());

		subSequenceWithAscii("", un);
		System.out.println();
		System.out.println(subSequenceAscii("", un));
	}

	private static void subSequenceWithAscii(String p, String un) {
		if (un.isEmpty()) {
			System.out.print(p+" ");
			return;
		}
		int i=un.charAt(0) + 0;
		subSequenceWithAscii(p + un.charAt(0), un.substring(1));
		subSequenceWithAscii(p+i , un.substring(1));
		subSequenceWithAscii(p, un.substring(1));
	}

	private static void subSequence(String p, String un) {
		if (un.isEmpty()) {
			al.add(p);
			return;
		}

		subSequence(p + un.charAt(0), un.substring(1));
		subSequence(p, un.substring(1));
	}

	private static ArrayList<String> subSequence1(String p, String un, ArrayList<String> al) {
		if (un.isEmpty()) {
			al.add(p);
			return al;
		}

		subSequence1(p + un.charAt(0), un.substring(1), al);
		subSequence1(p, un.substring(1), al);
		return al;
	}

	private static ArrayList<String> subSequence2(String p, String un) {
		if (un.isEmpty()) {
			ArrayList<String> al = new ArrayList<String>();
			al.add(p);
			return al;
		}

		ArrayList<String> left = subSequence2(p + un.charAt(0), un.substring(1));
		ArrayList<String> right = subSequence2(p, un.substring(1));

		left.addAll(right);
		return left;
	}
	
	private static ArrayList<String> subSequenceAscii(String p, String un) {
		if (un.isEmpty()) {
			ArrayList<String> al = new ArrayList<String>();
			al.add(p);
			return al;
		}
		
		char ch = un.charAt(0);

		ArrayList<String> first = subSequenceAscii(p + ch, un.substring(1));
		ArrayList<String>  second= subSequenceAscii(p + (ch+0), un.substring(1));
		ArrayList<String> third = subSequenceAscii(p, un.substring(1));

		first.addAll(second);
		first.addAll(third);
		return first;
	}

}
