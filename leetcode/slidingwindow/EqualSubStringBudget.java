package slidingwindow;
/*
 * https://leetcode.com/problems/get-equal-substrings-within-budget/
*/
public class EqualSubStringBudget {
	
	public static void main(String[] args) {
		String s = "abcd"; String t = "cdef"; int maxCost = 3;
		System.out.println(equalSubstring(s,t,maxCost));
		
	}
	public static int equalSubstring(String s, String t, int maxCost) {
        int i=0; int j=0;int charCount=0;  int sum=0;
     while(j<s.length() && j<t.length()) {
		char x = s.charAt(j);
     char y = t.charAt(j);
     sum+=Math.abs((y -'a') - (x -'a'));
		if(sum < maxCost) {
			 charCount = Math.max(charCount, j-i+1);
			j++;
		}
		else if(sum == maxCost){
		    charCount = Math.max(charCount, j-i+1);
			j++;
		}
		else if(sum >maxCost) {
			while(sum > maxCost) {
				char c= s.charAt(i);
             char d= t.charAt(i);
             sum-= Math.abs((d -'a') - (c -'a'));
				i++;
				}
         
				if(sum == maxCost){
		            charCount = Math.max(charCount, j-i+1);
				}
				j++;
			}
		}
		 
		return charCount;
 }

}
