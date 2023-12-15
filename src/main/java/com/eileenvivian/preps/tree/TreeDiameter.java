package com.eileenvivian.preps.tree;

// Recursive optimized Java program to find the diameter of
// a Binary Tree

// Class containing left and right child of current
// node and key value

import com.eileenvivian.preps.TreeNode;

// Class to print the Diameter
public class TreeDiameter {
    TreeNode root;

    // Method to calculate the diameter and return it to main
    private int getDiameter(TreeNode root)
    {
        // base case if tree is empty
        if (root == null)
            return 0;

        // get the height of left and right sub-trees
        int lheight = getHeight(root.left);
        int rheight = getHeight(root.right);

        return Math.max(lheight + rheight + 1,
                        Math.max(getDiameter(root.left), getDiameter(root.right)));
    }

    // A wrapper over diameter(Node root)
    public int getDiameter() { return getDiameter(root); }

    // The function Compute the "height" of a tree. Height
    // is the number of nodes along the longest path from
    // the root node down to the farthest leaf node.
    private static int getHeight(TreeNode node)
    {
        // base case tree is empty
        if (node == null)
            return 0;
        // If tree is not empty then height = 1 + max of
        //  left height and right heights
        return (1 + Math.max(getHeight(node.left), getHeight(node.right)));
    }

    // Driver Code
    public static void main(String args[])
    {
        // creating a binary tree and entering the nodes
        TreeDiameter tree = new TreeDiameter();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);

        // Function Call
        System.out.println(
                "The diameter of given binary tree is : "
                        + tree.getDiameter());
    }
}
