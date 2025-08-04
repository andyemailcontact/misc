package com.ifocus.work;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamExample {
    // remove "id" parameter and value from query string
    String query ="id=1&name=John&age=30&ts=123456";
    String newQuery = Arrays.stream(query.split("&"))
            .filter(param -> !param.startsWith("id="))
            .collect(Collectors.joining("&")); // Return new type
            //Other collectors:
    //Collectors.toList() - To collect into a list.
    //Collectors.toSet() - To collect into a set.
    //Collectors.toMap() - To collect into a map.
    //Collectors.joining() - To join elements into a string.
    //Collectors.groupingBy() - To group elements based on a certain criteria.
    //Collectors.summarizingInt()
}
