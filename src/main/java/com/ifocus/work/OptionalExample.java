package com.ifocus.work;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<String> name = Optional.of("John");

        // Using ifPresent, execute lambda expression if value is present
        boolean valid = false;
        name.ifPresent(value -> System.out.println("Hello, " + value));

        // If a value is present, returns the value, otherwise returns other.
        String greeting = name.orElse("Stranger");
        System.out.println("Hello, " + greeting);

        // Using orElseGet(supplier), return the value if present, otherwise return the value from the supplier lazily
        String anotherGreeting = name.orElseGet(() -> "Anonymous" + "1");
        System.out.println("Hello, " + anotherGreeting);
    }
}