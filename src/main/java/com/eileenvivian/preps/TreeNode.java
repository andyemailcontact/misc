package com.eileenvivian.preps;

public class TreeNode<T extends Comparable<?>> {
    public T val;
    public TreeNode left, right;

    public TreeNode(T item)
    {
        val = item;
        left = right = null;
    }
}
