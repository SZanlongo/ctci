package chapter_1_Arrays_Strings;

import java.util.Arrays;

public class Question_1_2 {
    public static void main(String[] args) {
        System.out.println(checkPermutation("aabbccdd", "ddbbaacc"));
        System.out.println(checkPermutation("asdl", "asdf"));
        System.out.println(checkPermutation("nrdsjwaehdui", "rsjaediunwdh"));
    }

    public static boolean checkPermutation(String str1, String str2) {
        // Note: permutation means that there are same number of each character in each string
        // have same characters (but different counts) is not enough
        //basic sanity checks
        if (str1.length() != str2.length()) {
            return false;
        }
        //convert strings to char arrays
        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();
        // sort strings
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        //check each char, if they are different, there is either a different char, or different count of char
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }
}
