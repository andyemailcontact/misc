package com.eileenvivian.preps.tree;

// Java program to print top
// view of binary tree
import com.eileenvivian.preps.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// class of binary tree
public class TopViewTree {
    TreeNode root;

    public TopViewTree() { root = null; }

    // function should print the topView of
    // the binary tree
    private void TopView(TreeNode root)
    {
        // It's okay to declare class here
        class QueueObj {
            TreeNode node;
            int hd;

            QueueObj(TreeNode node, int hd)
            {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<>();
        Map<Integer, TreeNode> topViewMap = new TreeMap<>();

        if (root == null) {
            return;
        }
        else {
            q.add(new QueueObj(root, 0));
        }

        System.out.println(
                "The top view of the tree is : ");

        // count function returns 1 if the container
        // contains an element whose key is equivalent
        // to hd, or returns zero otherwise.
        while (!q.isEmpty()) {
            QueueObj tmpNode = q.poll();
            topViewMap.putIfAbsent(tmpNode.hd, tmpNode.node);

            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left,
                        tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right,
                        tmpNode.hd + 1));
            }
        }
        for (Map.Entry<Integer, TreeNode> entry :
                topViewMap.entrySet()) {
            System.out.print(entry.getValue().val + " ");
        }
    }

    // Driver code
    public static void main(String[] args)
    {
		/* Create following Binary Tree
		1
	/ \
	2 3
	\
		4
		\
		5
			\
			6
*/
        TopViewTree tree = new TopViewTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.left.right.right = new TreeNode(5);
        tree.root.left.right.right.right = new TreeNode(6);
        tree.TopView(tree.root);
    }
}

