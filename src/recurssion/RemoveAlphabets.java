package recurssion;

public class RemoveAlphabets {

	public static void main(String[] args) {
		System.out.println(removeAlphabetsFromString("cabaccbaab"));
		System.out.println(removeWordFromString("cabappleccbaab"));
		System.out.println(removeAppNotApple("caappbappleccbaab"));
		removeAlphabetsFromString("", "cabaccbaab");
		removeAlphabetsFromString(new StringBuilder(), new StringBuilder("cabaccbaab"));
	}

	private static String removeAppNotApple(String s) {
		if (s.isEmpty()) {
			return "";
		}

		if (s.startsWith("app") && !s.startsWith("apple")) {
			return removeAppNotApple(s.substring(3));
		} else {
			return s.charAt(0) + removeAppNotApple(s.substring(1));
		}
	}

	private static String removeWordFromString(String s) {
		if (s.isEmpty()) {
			return "";
		}

		if (s.startsWith("apple")) {
			return removeWordFromString(s.substring(5));
		} else {
			return s.charAt(0) + removeWordFromString(s.substring(1));
		}
	}

	private static String removeAlphabetsFromString(String s) {
		if (s.isEmpty()) {
			return "";
		}

		if (s.charAt(0) != 'a') {
			return s.charAt(0) + removeAlphabetsFromString(s.substring(1));
		}

		return removeAlphabetsFromString(s.substring(1));
	}

	private static void removeAlphabetsFromString(String p, String unp) {
		if (unp.isEmpty()) {
			System.out.println(p);
			return;
		}

		if (unp.charAt(0) == 'a') {
			removeAlphabetsFromString(p, unp.substring(1));
		} else {
			removeAlphabetsFromString(p + unp.charAt(0), unp.substring(1));
		}
	}

	private static void removeAlphabetsFromString(StringBuilder p, StringBuilder unp) {
		if (unp.isEmpty()) {
			System.out.println(p);
			return;
		}

		if (unp.charAt(0) == 'a') {
			removeAlphabetsFromString(p, unp.deleteCharAt(0));
		} else {
			removeAlphabetsFromString(p.append(unp.charAt(0)), unp.deleteCharAt(0));
		}
	}
}