package com.ifocus.preps.tree;

import com.ifocus.preps.BTreePrinter;
import com.ifocus.preps.TreeNode;

import java.util.*;

// class TreeNode {
//   int val;
//   TreeNode left;
//   TreeNode right;

//   TreeNode(int x) {
//     val = x;
//   }
// };

class AllPathToSum {
    public List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        findPathsRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode<Integer> currentNode, int sum,
                                           List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (currentNode == null)
            return;

        // add the current node to the path
        currentPath.add(currentNode.val);

        // if the current node is a leaf and its value is equal to sum, save the current path
        if (currentNode.val == sum && currentNode.left == null
                && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            // traverse the left sub-tree
            findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
            // traverse the right sub-tree
            findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        AllPathToSum sol = new AllPathToSum();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(6);
        int sum = 23;
        BTreePrinter.printNode(root);
        List<List<Integer>> result = sol.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }

}
