package chapter1;

//Determine if string is permutation of other
public class Question1_3 {
	// Check if they have same chars, but different order
	// Assume ASCII 256 chars

	public static void main(String[] args) {
		String[][] pairs = { { "hello", "world" }, { "hello", "olleh" }, { "google", "ooggle" }, { "java", "aajv" },
				{ "cat", "dog" } };
		for (String[] pair : pairs) {
			String a = pair[0];
			String b = pair[1];
			System.out.println(a + "\t" + b + "\t" + permutation(a, b));
		}
	}

	// Sort to put chars in same order
	public static String sort(String str) {
		char[] charList = str.toCharArray();
		java.util.Arrays.sort(charList);
		return new String(charList);
	}

	// Compare sorted versions
	public static boolean permutation(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		return sort(a).equals(sort(b));
	}
}
