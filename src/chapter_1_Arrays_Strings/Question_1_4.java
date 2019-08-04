package chapter_1_Arrays_Strings;

import commonLibrary.CommonMethods;

//Replace all spaces in string with %20
public class Question_1_4 {

    /*
     * Assume string has space at end for extra chars Given true length of
     * string Java - use char array to perform in-place operation
     */
    public static void main(String[] args) {
        String str = "Hello world. ";
        char[] arr = new char[str.length() + 3 * 2 + 1];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        replaceSpaces(arr, str.length());
        // System.out.println(new String(arr));
        System.out.println(CommonMethods.charToString(arr));
    }

    /*
     * Work backwards: No worrying about overwriting
     */

    public static void replaceSpaces(char[] str, int length) {
        // count spaces in string to compute final length of string
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = length + spaceCount * 2;
        str[index] = '\0';
        // edit string in reverse order
        for (i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {// if space, copy %20 into next positions
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {// not space, copy original char
                str[index - 1] = str[i];
                index--;
            }
        }
    }
}
