package chapter_1_Arrays_Strings;

//Basic string compression
//aabcccccaaa =  a2b1c5a3
public class Question_1_5 {

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        String answer = "a2b1c5a3";
        System.out.println("Original:\t" + str);
        System.out.println("Answer:\t" + answer);
        System.out.println("Bad:\t" + compressBad(str));
        System.out.println("Good:\t" + compressGood(str));
    }

    // naive approach, could return a larger string
    // Time: O(s + c^2), s = string size, c = # of char sequences
    // Concatenation is O(n^2)
    public static String compressBad(String str) {
        String out = "";
        char prev = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == prev) {
                count++;
            } else {
                out += prev + "" + count;
                prev = str.charAt(i);
                count = 1;
            }
        }

        return out + prev + count;
    }

    // Time: O(n)
    // Space: O(n)
    public static String compressGood(String str) {
        int size = compressBad(str).length(); // end size of string

        if (size >= str.length()) {
            return str;
        }

        char[] out = new char[size]; // charr array with correct size
        int idx = 0;
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {// repeat char
                count++;
            } else {// update repeat char count
                idx = setChar(out, last, idx, count);
                last = str.charAt(i);
                count = 1;
            }
        }

        idx = setChar(out, last, idx, count);// update string with last char

        return String.valueOf(out);
    }

    public static int setChar(char[] array, char c, int i, int count) {
        array[i] = c;
        i++;

        // change to string, then change to array
        char[] list = String.valueOf(count).toCharArray();

        // copy from large to small
        for (char x : list) {
            array[i] = x;
            i++;
        }

        return i;
    }
}
