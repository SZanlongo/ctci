package chapter_4_Trees_Graphs;

import commonLibrary.CommonMethods;
import commonLibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

//Given binary tree: create linked list of nodes at each level 
public class Question_4_4 {

    public static void main(String[] args) {
        TreeNode root = CommonMethods.createBST(10);
        printLevels(BFSNodesAtLevel(root));
    }

    private static void printLevels(ArrayList<LinkedList<TreeNode>> levels) {
        for (LinkedList<TreeNode> n : levels) {
            ListIterator<TreeNode> iter = n.listIterator();

            while (iter.hasNext()) {
                System.out.println(iter.next().data);
            }
            System.out.println();
        }
    }

    public static ArrayList<LinkedList<TreeNode>> BFSNodesAtLevel(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> levels = new ArrayList<LinkedList<TreeNode>>();// all
        // levels

        LinkedList<TreeNode> level = new LinkedList<TreeNode>();// current level

        if (root != null) {
            level.add(root);
        }

        while (level.size() > 0) {// unexplored nodes
            levels.add(level);// done with level, add to all

            LinkedList<TreeNode> prevLevel = level;// store level parents
            level = new LinkedList<TreeNode>();// clear level

            for (TreeNode n : prevLevel) {
                // add children
                if (n.left != null) {
                    level.add(n.left);
                }
                if (n.right != null) {
                    level.add(n.right);
                }
            }
        }
        return levels;
    }
}
