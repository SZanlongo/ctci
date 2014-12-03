package ctci;

//Determine if a string has all unique characters
public class Question1 {
	// Check if ASCII (128, 256 chars) or Unicode

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

	public static void main(String[] args) {
		String[] words = { "abcde", "hello", "world", "java", "poodle" };
		for (String word : words) {
			System.out.println(word + ":\t" + isUniqueChars(word));
		}
	}

}
