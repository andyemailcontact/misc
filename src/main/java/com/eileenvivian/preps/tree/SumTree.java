package com.eileenvivian.preps.tree;

import com.eileenvivian.preps.BTreePrinter;
import com.eileenvivian.preps.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
           1
        /     \
      3        -1
    /   \     /   \
  2     1   4       5
      /   /   \      \
    1   1       2     6
 */
public class SumTree {
    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(-1);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(2);
        BTreePrinter.printNode(root);

        int k = 5;
        printKPath(root, new ArrayList<>(), k);
    }
    private static void printKPath(TreeNode<Integer> node, List<Integer> list, int sum) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        printKPath(node.left, list, sum);
        printKPath(node.right, list, sum);
        int total=0;
        for(int i=list.size()-1; i>=0; i--) {
            total += list.get(i);
            if (total == sum) {
                for(int j=list.size()-1; j>=i; j--) {
                    System.out.print(list.get(j) + ", ");
                }
                System.out.println();
            }
        }
        list.remove(list.size()-1);

    }
}
