package chapter_4_Trees_Graphs;

import commonLibrary.CommonMethods;
import commonLibrary.TreeNode;

//Find the next node of a given node in a BST
public class Question_4_6 {

    public static void main(String[] args) {
        TreeNode root = CommonMethods.createBST(10);
        root.print();

        TreeNode curr = root.left.right;
        System.out.println(curr.data);
        TreeNode next = findNext(curr);

        if (next != null) {
            System.out.println(next.data);
        }
    }

    public static TreeNode findNext(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.right != null) {
            // go to right child, then to left-most child
            TreeNode leftmost = root.right;
            while (leftmost.left != null) {
                leftmost = leftmost.left;
            }
            return leftmost;
        }

        // no right child, have to go up
        TreeNode parent = root;
        // if left of parent, then go to parent
        TreeNode unexplored = parent.parent;
        // if right of parent, then keep going up
        while (unexplored != null && unexplored.left != parent) {
            parent = unexplored;
            unexplored = unexplored.parent;
        }
        return unexplored;
    }

}
