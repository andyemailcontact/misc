package com.ifocus.work;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

public class StreamExample {
    public static void main(String[] args) {
        // Example usage of the people list
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 20),
                new Person("David", 20));
        List<Person> list = people.stream().sorted(
                (p1, p2) -> {
                    int ageComparison = Integer.compare(p1.getAge(), p2.getAge());
                    if (ageComparison != 0) {
                        return ageComparison; // Sort by age first
                    }
                    return p1.getName().compareTo(p2.getName()); // Then by name
                })
                .collect(Collectors.toList());
        list.forEach(System.out::println);


    }

}
