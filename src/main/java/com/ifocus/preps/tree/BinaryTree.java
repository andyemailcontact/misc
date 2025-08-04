package com.ifocus.preps.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    // Method to insert a new node into the binary tree
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    // Recursive helper method for insertion
    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }
        // If value already exists, do nothing (for a simple BST)

        return current;
    }

    // Example of a traversal method (in-order)
    public void inorderTraversal() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.value + " ");
            inorderRecursive(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Inserting elements
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(41);
        tree.insert(75);
        tree.insert(80);
        tree.insert(88);
        tree.insert(91);
        printVerticalOrder(tree.root);
    }

    static class QueueNode {
        Node node;
        int hd; // Horizontal Distance

        public QueueNode(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void printVerticalOrder(Node root) {
        if (root == null) {
            return;
        }

        // Map to store nodes at each horizontal distance
        // Key: Horizontal Distance, Value: List of nodes at that HD
        Map<Integer, List<Integer>> verticalMap = new TreeMap<>();
        Queue<QueueNode> queue = new LinkedList<>();

        // Add root with HD 0
        queue.add(new QueueNode(root, 0));

        int minHd = 0;
        int maxHd = 0;

        while (!queue.isEmpty()) {
            QueueNode current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            // Update min and max HD for iteration later
            minHd = Math.min(minHd, hd);
            maxHd = Math.max(maxHd, hd);

            // Add node data to the list for its HD
            verticalMap.computeIfAbsent(hd, k -> new ArrayList<>()).add(node.value);

            // Add left child with HD-1
            if (node.left != null) {
                queue.add(new QueueNode(node.left, hd - 1));
            }
            // Add right child with HD+1
            if (node.right != null) {
                queue.add(new QueueNode(node.right, hd + 1));
            }
        }

        // Print the vertical order
        for (int i = minHd; i <= maxHd; i++) {
            List<Integer> nodesAtHd = verticalMap.get(i);
            if (nodesAtHd != null) {
                // Print basic "line" for visual separation
                System.out.print("-----");
                for (int val : nodesAtHd) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }
}
