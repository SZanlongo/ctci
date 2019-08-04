package chapter_4_Trees_Graphs;

import commonLibrary.CommonMethods;
import commonLibrary.TreeNode;

//create minimal height BST from sorted array
public class Question_4_3 {

    public static void main(String[] args) {
        TreeNode root = CommonMethods.createBST(10);
        root.print();
    }

}
