package com.eileenvivian.preps.misc;


import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {
    Map<Integer, Node> map;
    Node head, tail;

    int capacity;
    public LRUCache(int cap) {
        capacity = cap;
        map = new HashMap<>();
    }
    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            addToFront(node);
            return node.key;
        } else {
            return -1;
        }
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToFront(node);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= this.capacity) {
                remove(tail);
                map.remove(tail.key);
            }
            addToFront(newNode);
            map.put(key, newNode);
        }
    }

    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }
    private void addToFront(Node node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }
}
