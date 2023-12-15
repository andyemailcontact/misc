package com.eileenvivian.preps.misc;

import java.util.ArrayDeque;
import java.util.Deque;

public class PlayGround {
    public static void main(String[] args) {
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(1);
        arrayDeque.add(2);
        arrayDeque.add(3);
        arrayDeque.addFirst(6);
        System.out.println(arrayDeque);
        arrayDeque.remove();
        System.out.println(arrayDeque);
    }

}
