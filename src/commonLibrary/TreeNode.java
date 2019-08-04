package commonLibrary;

import java.util.Arrays;

public class TreeNode {
    public int data;
    public TreeNode parent, left, right;
    public int height = 0; // Question 4 - 1
    public int state = 0;// 0 = unvisited, 1 = visited

    public TreeNode(int data) {
        this.data = data;
    }

    // own version of createMinimalBST
    public static TreeNode createMinHeightBST(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        int mid = arr.length / 2;
        TreeNode root = new TreeNode(arr[mid]);

        root.left = createMinHeightBST(Arrays.copyOfRange(arr, 0, mid));
        if (root.left != null) {
            root.left.parent = root;
        }

        root.right = createMinHeightBST(Arrays.copyOfRange(arr, mid + 1, arr.length));
        if (root.right != null) {
            root.right.parent = root;
        }

        return root;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    // from gayle ctci
    // public static TreeNode createMinimalBST(int array[]) {
    // return createMinimalBST(array, 0, array.length - 1);
    // }

    // from gayle ctci
    // private static TreeNode createMinimalBST(int arr[], int start, int end) {
    // if (end < start) {
    // return null;
    // }
    // int mid = (start + end) / 2;
    // TreeNode n = new TreeNode(arr[mid]);
    // n.setLeft(createMinimalBST(arr, start, mid - 1));
    // n.setRight(createMinimalBST(arr, mid + 1, end));
    // return n;
    // }

    public void setRight(TreeNode right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    // from gayle ctci
    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                setLeft(new TreeNode(d));
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                setRight(new TreeNode(d));
            } else {
                right.insertInOrder(d);
            }
        }
        height++;
    }

    // from gayle ctci
    public void print() {
        BTreePrinter.printNode(this);
    }

}
