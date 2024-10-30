package com.ifocus.preps.tree;

import com.ifocus.preps.TreeNode;

import java.util.Stack;

public class Traversal {
    // InOrder
    public void inOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode top = stack.pop();
            // visit top.val;
            current = top.right;
        }
    }

    // PreOrder
    public void preOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // visit(current.value);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
