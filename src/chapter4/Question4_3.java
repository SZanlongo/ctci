package chapter4;

import java.util.Arrays;

import commonLibrary.TreeNode;

//create minimal height BST from sorted array
public class Question4_3 {
	public static final int TREE_SIZE = 10;

	public static void main(String[] args) {
		int[] arr = new int[TREE_SIZE];
		for (int i = 0; i < TREE_SIZE; i++) {
			arr[i] = i + 1;
		}

		TreeNode root = TreeNode.createMinHeightBST(arr);
		root.print();
	}

}
