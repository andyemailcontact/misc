package com.eileenvivian.preps.fastslowpointers;

import java.util.Arrays;
import java.util.Random;

/*
 * Given a positive number n, return true if it is a happy number otherwise return false
 * Input: 23
Output: true (23 is a happy number)
Explanations: Here are the steps to find out that 23 is a happy number:
 = 4 + 9 = 13
 = 1 + 9 = 10
 = 1 + 0 = 1
 * Input: 12
Output: false (12 is not a happy number)
Explanations: Here are the steps to find out that 12 is not a happy number:
 = 1 + 4 = 5
= 25
 = 4 + 25 = 29
 = 4 + 81 = 85
 = 64 + 25 = 89
 = 64 + 81 = 145
 = 1 + 16 + 25 = 42
 = 16 + 4 = 20
 = 4 + 0 = 4
 = 16
 = 1 + 36 = 37
 = 9 + 49 = 58
 = 25 + 64 = 89
Please note the cycle from 89 -> 89.
 */
class HappyNumber {

    public static boolean find(int num) {
        int slow = num, fast = num;
        do {
            slow = findSquareSum(slow); // move one step
            fast = findSquareSum(findSquareSum(fast)); // move two steps
        } while (slow != fast); // found the cycle

        return slow == 1; // see if the cycle is stuck on the number '1'
    }

    private static int findSquareSum(int num) {
        int sum = 0, digit;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(HappyNumber.find(23));
//        System.out.println(HappyNumber.find(12));
        for(int i=0; i<8; i++) {
            //i+1 to size-1
            System.out.println(new Random().nextInt(9- i -1) + (i + 1));
        }
        int[][]arr = new int[2][2];
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
    }
}