package chapter_4_Trees_Graphs;

import commonLibrary.CommonMethods;
import commonLibrary.TreeNode;

//Find the first common ancestor of two nodes in a binary tree
//Avoid storing nodes
public class Question_4_7 {

    public static void main(String[] args) {
        TreeNode root = CommonMethods.createBST(10);
        root.print();
        TreeNode childA = root.left.left;
        TreeNode childB = root.right.right;
        System.out.println("Nodes:\t" + childA.data + "\t" + childB.data);

        TreeNode ancestor = commonAncestor(root, childA, childB);
        if (ancestor != null) {
            System.out.println("Ancestor:\t" + ancestor.data);
        } else {
            System.out.println("No common ancestor");
        }
    }

    public static TreeNode commonAncestor(TreeNode root, TreeNode childA, TreeNode childB) {
        if (root == null) {
            return null;
        }

        // root is either a or b, so must be ancestor
        if (root == childA || root == childB) {
            return root;
        }

        TreeNode left = commonAncestor(root.left, childA, childB);
        TreeNode right = commonAncestor(root.right, childA, childB);

        // root is their ancestor
        if (left != null && right != null) {
            return root;
        }

        // if both on left/right, then ancestor is in left/right
        if (left != null) {
            return left;
        }
        return right;
    }

}
