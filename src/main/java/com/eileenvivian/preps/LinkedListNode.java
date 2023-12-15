package com.eileenvivian.preps;

public class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next, prev;

    public LinkedListNode(T item)
    {
        data = item;
    }
}
