package com.ifocus;

public class Samples {
    public static void main(String[] args) {
        // Create an array and initialize it
        String[] cars = {"Volvo", "BMW", "Ford"};

        // 4x2 matrix
        int[][]  moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        String str = "Hello World";
        for(char c : str.toCharArray()) {
            System.out.println(c);
        }
        for(int i=0; i<str.length(); i++) {
            System.out.println(str.charAt(i));
        }

    }
}
