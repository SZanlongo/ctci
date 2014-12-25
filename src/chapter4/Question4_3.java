package chapter4;

import commonLibrary.CommonMethods;
import commonLibrary.TreeNode;

//create minimal height BST from sorted array
public class Question4_3 {

	public static void main(String[] args) {
		TreeNode root = CommonMethods.createBST(10);
		root.print();
	}

}
