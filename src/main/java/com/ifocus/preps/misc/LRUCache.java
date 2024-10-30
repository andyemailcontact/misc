package com.ifocus.preps.misc;

import java.util.HashMap;

class LinkedNode {
    int key;
    int value;
    LinkedNode prev;
    LinkedNode next;

    public LinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    LinkedNode head;
    LinkedNode tail;
    HashMap<Integer, LinkedNode> map;
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        // Key Already Exist, just update the access order by moving
        if (map.containsKey(key)) {
            LinkedNode node = map.get(key);
            removeNode(node);
            addAtFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // key already exists. remove and move to front.
        if (map.containsKey(key)) {
            LinkedNode node = map.get(key);
            node.value = value;
            removeNode(node);
            addAtFront(node);
        } else {
            LinkedNode newNode = new LinkedNode(key, value);
            if (map.size() >= cap) {
                map.remove(tail.key);
                removeNode(tail);
            }
            addAtFront(newNode);
            map.put(key, newNode);
        }
    }

    public void addAtFront(LinkedNode node) {
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

    public void removeNode(LinkedNode node) {
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

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // 2 is capacity of the cache.
        cache.put(1, 4);
        cache.put(2, 5);
        System.out.println(cache.get(1)); // returns 4
        System.out.println(cache.get(5)); // returns -1
        cache.put(3, 6); // removes key 2
        System.out.println(cache.get(2)); // retruns -1
    }
}
