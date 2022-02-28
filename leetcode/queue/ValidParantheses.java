package queue;

import java.util.Stack;

public class ValidParantheses {

	public static void main(String[] args) {
		System.out.println(isValid("(){}[]"));
	}
	public static boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(' || c == '{' || c == '[') {
				st.push(c);
			} else if (c == ')') {
				if (st.size() == 0 || st.peek() != '(') {
					return false;
				} else {
					st.pop();
				}

			} else if (c == '}') {
				if (st.size() == 0 || st.peek() != '{') {
					return false;
				} else {
					st.pop();
				}

			} else if (c == ']') {
				if (st.size() == 0 || st.peek() != '[') {
					return false;
				} else {
					st.pop();
				}

			} else {
				return false;
			}
		}
		if (st.size() > 0) {
			return false;
		}

		return true;
	}

}
