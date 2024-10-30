package com.ifocus;

// Make sure not to declare this class public
class HelperClass {
    public void print() {
        System.out.println("Helper class");
    }
}

public class MultiClass {
    static class InnerClass {
        public void print() {
            System.out.println("Inner class");
        }
    }
    public static void main(String[] args) {
        new InnerClass().print();
        new HelperClass().print();
    }
}
