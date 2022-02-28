package queue;

import java.util.Stack;

public class RemovalOfAdjecentDup {
	Stack<Character> st = new Stack<>();
	StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		System.out.println(new RemovalOfAdjecentDup().removeDuplicates("abbaca"));
	}

	public String removeDuplicates(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (st.size() == 0 || st.peek() != c) {
				st.push(c);
				sb.append(c);
			} else {
				st.pop();
				sb.setLength(sb.length()-1);
			}
		}
		return sb.toString();
	}
}
