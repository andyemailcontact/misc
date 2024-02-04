package com.eileenvivian.preps.lang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CodeThis {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[] {"a.b.c", "a.c.d", "e.f.g"});
//        list.stream().sorted((a, b) -> b - a).filter(a -> a > 10).forEach(System.out::println);

        Queue<String> queue = new LinkedList<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
        queue.remove(1);
        System.out.println(queue);

    }

}
