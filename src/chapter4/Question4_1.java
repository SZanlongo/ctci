package chapter4;

import commonLibrary.TreeNode;

//check if a binary tree is balanced
public class Question4_1 {
	public static final int TREE_SIZE = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[TREE_SIZE];
		for (int i = 0; i < TREE_SIZE; i++) {
			arr[i] = i;
		}

		TreeNode root = TreeNode.createMinimalBST(arr);// from gayle ctci
		System.out.println("Is balanced? " + checkBalanced(root));
		root.print();

		root.insertInOrder(4); // Add 4 to make it unbalanced
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
