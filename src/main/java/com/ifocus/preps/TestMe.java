package com.ifocus.preps;

public class TestMe {

    record Person(int id, String name, double salary, Department department) {}
    record Department(int id, String name) {}

    public static void main(String[] args) {
        String value = "nguyentancuong".replaceAll(".(?=.{4})", "*");
        System.out.println(value);
    }
}
