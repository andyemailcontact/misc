package com.ifocus.work;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommonUtils {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String firstNonNull = ObjectUtils.firstNonNull(null, "Hello", null, "World");
        System.out.println(firstNonNull); // Output: Hello

        Optional<String> opt = Optional.of("Hello");

        opt.ifPresentOrElse(obj -> System.out.println(opt.get()),
                () -> System.out.println("null optional"));

        Optional<String> optional = Optional.ofNullable(null);
        // This will return the default value "null value"
        System.out.println(optional.orElse("null value"));

        // call a supplier function to get default value
        System.out.println(optional.orElseGet(CommonUtils::getDefaultValue));

        // throw if optional is empty
//        System.out.println(optional.orElseThrow(() -> new Exception("Resource not found.")));

        Optional<Integer> optional2 = Optional.ofNullable(12);

        // if present, consume the value

        optional2.ifPresent(System.out::println); // print only if present
        Integer val2 = optional2.orElse(0); // extract value, if null return 0
        // optional map from one type to another, i.e. filter
        optional2
                .map(val -> String.valueOf(val))
                .filter(val -> val.length() > 1)
                .ifPresentOrElse(System.out::println, () -> System.out.println("No value found")); // terminated

        // remove "id" parameter and value from query string
        String query ="id=1&name=John&age=30&ts=123456";
        String newQuery = Arrays.stream(query.split("&"))
                .filter(param -> !param.startsWith("id="))
                .collect(Collectors.joining("&"));

        // Stream
        // .filter(Objects::nonNull)

    }

    // producer function returning a String
    public static String getDefaultValue() {
        return "Default Value";
    }
}
