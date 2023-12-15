package com.eileenvivian.preps.misc;

import com.eileenvivian.preps.LinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    LinkedListNode<Integer> head, tail;
    int size;
    Map<Integer, LinkedListNode> map;
    public LRUCache(int cap) {
        this.size = cap;
        map = new HashMap<>();
    }
    private void addToTop(LinkedListNode<Integer> node) {
        node.next = head;
        node.prev = null;
        if (head != null)
            head.prev = node;
        head = node;
        if (tail == null)
            tail = head;
    }
    private void removeNode(LinkedListNode node) {
        // check if node is not head
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        // check if node is not tail
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }
}
