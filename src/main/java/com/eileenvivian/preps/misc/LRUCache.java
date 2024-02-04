package com.eileenvivian.preps.misc;


import java.util.LinkedHashMap;

public class LRUCache {
    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    private int cap;
    LRUCache(int cap) {
        this.cap = cap;
    }
    void remove() {
        int key = map.entrySet().iterator().next().getKey();
        map.remove(key);
    }
}
