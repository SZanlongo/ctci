package chapter_9_Recursion_DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//Return all subsets of a set
public class Question_9_4 {

    // at most 2^n subsets
    // space: O(2^n)
    // time: O(2^n)
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        Set<Set<Integer>> powerset = getPowerset(set);
        printSet(powerset);
    }

    public static <T> Set<Set<T>> getPowerset(Set<T> originalSet) {
        Set<Set<T>> powerset = new HashSet<Set<T>>();
        Set<T> newSet = new HashSet<T>();
        if (originalSet.isEmpty()) {
            powerset.add(newSet);
        } else {
            ArrayList<T> list = new ArrayList<T>(originalSet);
            T head = list.get(0);
            Set<T> remaining = new HashSet<T>(list.subList(1, list.size()));
            for (Set<T> currSet : getPowerset(remaining)) {
                newSet = new HashSet<T>();
                newSet.add(head);
                newSet.addAll(currSet);
                powerset.add(newSet);
                powerset.add(currSet);
            }
        }
        return powerset;
    }

    public static <T> void printSet(Set<Set<T>> powerset) {
        for (Set<T> set : powerset) {
            String out = "";
            for (T elem : set) {
                out += elem.toString() + "\t";
            }
            System.out.println(out);
        }
    }

}
