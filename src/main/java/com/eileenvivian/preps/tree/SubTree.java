package com.eileenvivian.preps.tree;

// Java program to check if binary tree is subtree of
// another binary tree

// A binary tree node


import com.eileenvivian.preps.TreeNode;

public class SubTree {
    TreeNode root1, root2;

    /* A utility function to check whether trees with roots
    as root1 and root2 are identical or not */
    boolean areIdentical(TreeNode root1, TreeNode root2) {

        /* base cases */
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

		/* Check if the data of both roots is same and data
		of left and right subtrees are also same */
        return (root1.val == root2.val
                && areIdentical(root1.left, root2.left)
                && areIdentical(root1.right, root2.right));
    }

    /* This function returns true if tree2 is a subtree of T,
     * otherwise false */
    boolean isSubtree(TreeNode tree1, TreeNode tree2) {
        /* base cases */
        if (tree2 == null)
            return true;

        if (tree1 == null)
            return false;

        /* Check the tree with root as current node */
        if (areIdentical(tree1, tree2))
            return true;

		/* If the tree with root as current node doesn't
		match then
		try left and right subtrees one by one */
        return isSubtree(tree1.left, tree2)
                || isSubtree(tree1.right, tree2);
    }

    public static void main(String args[]) {
        SubTree tree = new SubTree();

        // TREE 1
		/* Construct the following tree
			26
			/ \
			10	 3
		/ \	 \
		4	 6	 3
		\
			30 */

        tree.root1 = new TreeNode(26);
        tree.root1.right = new TreeNode(3);
        tree.root1.right.right = new TreeNode(3);
        tree.root1.left = new TreeNode(10);
        tree.root1.left.left = new TreeNode(4);
        tree.root1.left.left.right = new TreeNode(30);
        tree.root1.left.right = new TreeNode(6);

        // TREE 2
		/* Construct the following tree
		10
		/ \
		4	 6
		\
		30 */

        tree.root2 = new TreeNode(10);
        tree.root2.right = new TreeNode(6);
        tree.root2.left = new TreeNode(4);
        tree.root2.left.right = new TreeNode(30);

        if (tree.isSubtree(tree.root1, tree.root2))
            System.out.println(
                    "Tree 2 is subtree of Tree 1 ");
        else
            System.out.println(
                    "Tree 2 is not a subtree of Tree 1");
    }
}

// This code has been contributed by Mayank Jaiswal

