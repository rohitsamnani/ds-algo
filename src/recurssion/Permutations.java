package recurssion;
// permutations of abc is => [abc,cba,bca,bac,cab,acb], count is equal to 3! = 3*2=6

import java.util.ArrayList;

public class Permutations {

	public static void main(String[] args) {
		printPermutations("", "abc");
		System.out.println();
		permutations("","abc");
		System.out.println(printPermutations1("","abc"));
		System.out.println("permuation of abc is 3! = "+ permutationsCount("","abc"));

	}
	
	private static int permutationsCount(String p, String unp) {
		if (unp.isEmpty()) {
			return 1;
		}
		int count=0;
		for (int i = 0; i <= p.length(); i++) {
			count= count + permutationsCount(p.substring(0,i)+unp.charAt(0)+p.substring(i,p.length()), unp.substring(1));
		}
		return count;
	}

	private static void printPermutations(String p, String unp) {
		if (unp.isEmpty()) {
			System.out.print(p + " ");
			return;
		}
		for (int i = 0; i <= p.length(); i++) {
			printPermutations(p.substring(0,i)+unp.charAt(0)+p.substring(i,p.length()), unp.substring(1));
		}
	}
	private static ArrayList<String> printPermutations1(String p, String unp) {
		if (unp.isEmpty()) {
			ArrayList<String> al = new ArrayList<>();
			al.add(p);
			return al;
		}
		ArrayList<String> ans = new ArrayList<>();
		for (int i = 0; i <= p.length(); i++) {
			ans.addAll(printPermutations1(p.substring(0,i)+unp.charAt(0)+p.substring(i,p.length()), unp.substring(1)));
		}
		
		return ans;
	}
	
	static void permutations(String p, String un) {
		if(un.isEmpty()) {
			System.out.print(p+" ");
			return;
		}
		
		for(int i=0;i<=p.length();i++) {
			permutations(p.substring(0,i)+un.charAt(0)+p.substring(i,p.length()), un.substring(1));
		}
	}

	/*
	 * =>CAB 
	 * String k= sub.substring(0,0); String j = ""+s.charAt(0); String l=
	 * sub.substring(0,sub.length()); System.out.println(k+j+l);
	 * 
	 * =>ACB 
	 * k= sub.substring(0,1); j = ""+s.charAt(0); l=
	 * sub.substring(1,sub.length()); System.out.println(k+j+l);
	 * 
	 * =>ABC 
	 * k= sub.substring(0,2); j = ""+s.charAt(0); l=
	 * sub.substring(2,sub.length()); System.out.println(k+j+l);
	 * 
	 * for(int i=0;i<=sub.length();i++) { System.out.print(sub.substring(0,i) +
	 * s.charAt(0) + sub.substring(i,sub.length()) +" "); }
	 */
}
