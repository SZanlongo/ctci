package chapter_9_Recursion_DP;

import java.util.ArrayList;

//Compute all permutations of a String
public class Question_9_5 {
    final static String STR = "abc";

    public static void main(String[] args) {
        ArrayList<String> perms = permutations(STR);

        for (String s : perms) {
            System.out.println(s);
        }
    }

    // modified based on ctci solution
    public static ArrayList<String> permutations(String str) {
        ArrayList<String> perms = new ArrayList<String>();

        if (str.length() == 0) {
            perms.add("");
        } else {
            char c = str.charAt(0);
            String remainder = str.substring(1);
            ArrayList<String> words = permutations(remainder);

            for (String word : words) {
                for (int j = 0; j <= word.length(); j++) {
                    // get first, char, and end
                    perms.add(word.substring(0, j) + c + word.substring(j));
                }
            }
        }
        return perms;
    }
}
