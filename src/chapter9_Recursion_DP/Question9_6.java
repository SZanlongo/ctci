package chapter9_Recursion_DP;

import java.util.ArrayList;

// Print all valid combinations of n-pairs of parentheses
public class Question9_6 {

	public static final int N = 3;

	public static void main(String[] args) {
		ArrayList<String> list = printParentheses(N);
		for (String s : list) {
			System.out.println(s);
		}
	}

	public static void printParentheses(int l, int r, char[] str, int i, ArrayList<String> allPairs) {
		if (l == 0 && r == 0) {
			// no more parentheses
			String s = String.copyValueOf(str);
			allPairs.add(s);
			return;
		}
		
		if (l > 0) {
			// left parentheses
			str[i] = '(';
			printParentheses(l - 1, r, str, i + 1, allPairs);
		}
		if (r > l) {
			// right parentheses
			str[i] = ')';
			printParentheses(l, r - 1, str, i + 1, allPairs);
		}

	}

	public static ArrayList<String> printParentheses(int n) {
		char[] str = new char[n * 2];
		ArrayList<String> allPairs = new ArrayList<String>();
		printParentheses(n, n, str, 0, allPairs);
		return allPairs;
	}

}
