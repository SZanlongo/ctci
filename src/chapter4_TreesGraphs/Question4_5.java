package chapter4_TreesGraphs;

import commonLibrary.CommonMethods;
import commonLibrary.TreeNode;

//Check if binary tree is BST
public class Question4_5 {

	public static void main(String[] args) {
		TreeNode root = CommonMethods.createBST(10);
		// root.left.data = 10;// make child break
		// root.left.right.data=7;//make grandchild break
		root.print();
		System.out.println(checkBST(root));
	}

	public static boolean checkBST(TreeNode root) {
		// required for cases where a child is <, >, a grandparent
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean checkBST(TreeNode root, int low, int high) {
		// base case
		if (root == null) {
			return true;
		}
		// check against grandparent
		if (root.data <= low || root.data > high) {
			return false;
		}

		// check children
		return checkBST(root.left, low, root.data) && checkBST(root.right, root.data, high);
	}

}
