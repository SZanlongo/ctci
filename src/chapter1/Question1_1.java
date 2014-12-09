package chapter1;

//Determine if a string has all unique characters
public class Question1_1 {
	// Check if ASCII (128, 256 chars) or Unicode

	public static void main(String[] args) {
		String[] words = { "abcde", "hello", "world", "java", "poodle" };
		for (String word : words) {
			System.out.println(word + ":\t" + isUniqueChars(word));
		}
	}

	// Naive approach would compare every char with every other char
	// Time: O(n^2)
	// Space: O(1)

	// Time: O(n)
	// Space: O(1)
	public static boolean isUniqueChars(String str) {
		// false if length of string is > unique characters in alphabet
		if (str.length() > 256) {
			return false;
		}
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {// sloppy, implicitly casts char to int
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	// Could also try sorting the string in O(n log(n)) time
	// Then compare neighboring chars for match
}
