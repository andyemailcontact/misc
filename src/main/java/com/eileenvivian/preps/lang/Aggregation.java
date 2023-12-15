package com.eileenvivian.preps.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aggregation {
    public static void main(String[] args) {
        List<String> names = List.of("andy", "vivian", "eileen", "anthony", "ella");
        // {a=[andy, anthony], e=[eileen, ella], v=[vivian]}
        Map<String, List<String>> map = names.stream().collect(Collectors.groupingBy(a->a.substring(0, 1)));
        // {ella=1, eileen=1, vivian=1, anthony=1, andy=1}
        Map<String, Long> counts = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // list.stream().distinct().count();
        // List<String> answer = list.stream().map(String::toUpperCase).
        //        collect(Collectors.toList());
        System.out.println(counts);
        List<Integer> list = List.of(1, 5, 4, 3, 7, 6, 9, 4);
        Integer maxInt = list.stream().max(Integer::compare).get();
        System.out.println("max=" + maxInt);
        //Integer minInt = list.stream().mapToInt(i -> i).min().getAsInt();
    }
}
