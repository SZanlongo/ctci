package chapter_1_Arrays_Strings;

//Assume: given isSubstring
//Find if s2 is a rotation of s1
//using only one call to isSubstring
public class Question_1_8 {

    public static void main(String[] args) {
        String[][] pairs = {{"hello", "world"}, {"waterbottle", "erbottlewat"}, {"came", "mace"},
                {"google", "oogleg"}, {"automobile", "mobileauto"}};
        for (String[] pair : pairs) {
            String w1 = pair[0];
            String w2 = pair[1];
            System.out.println(w1 + "\t" + w2 + "\t" + isRotation(w1, w2));
        }
    }

    public static boolean isRotation(String s1, String s2) {
        // concatenate s1 to itself
        // this will include all of the wrap-around possibilities
        String s12 = s1 + s1;
        return isSubstring(s12, s2);
    }

    public static boolean isSubstring(String s1, String s2) {
        if (s1.indexOf(s2) >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
