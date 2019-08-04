package chapter_4_Trees_Graphs;

import commonLibrary.CommonMethods;
import commonLibrary.TreeNode;

//check if a binary tree is balanced
public class Question_4_1 {

    public static void main(String[] args) {

        TreeNode root = CommonMethods.createBST(10);
        System.out.println("Is balanced? " + checkBalanced(root));
        root.print();

        // root.insertInOrder(4);// from gayle ctci
        root.print();
        System.out.println("Is balanced? " + checkBalanced(root));
    }

    public static boolean checkBalanced(TreeNode root) {
        return checkHeight(root) == -1 ? false : true;
    }

    public static int checkHeight(TreeNode root) {
        if (root == null) {// leaf
            return 0;
        }

        int left = checkHeight(root.left);// get height of left subtree
        if (left == -1) {
            return -1;
        }

        int right = checkHeight(root.right);// get height of right subtree
        if (right == -1) {
            return -1;
        }

        int diff = left - right;
        return Math.abs(diff) > 1 ? -1 : Math.max(left, right) + 1;
    }

}
