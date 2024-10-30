package com.ifocus.preps.misc;

import java.util.Arrays;

public class Misc {
    public void pushZerosToEnd(int arr[], int n) {
        int count = 0;  // Count of non-zero elements

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i]; // here count is
            }
        }
        while (count < n)
            arr[count++] = 0;
    }

    // This method removes duplicates from a sorted integer array and returns the length of the modified array.
    public int removeDuplices(int[] arr) {
        int nextNonDuplicate = 1; // Initialize the index of the next non-duplicate element

        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Check if the current element is different from the previous non-duplicate element
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                // If different, copy the current element to the nextNonDuplicate position
                arr[nextNonDuplicate] = arr[i];
                // Increment the index of the next non-duplicate element
                nextNonDuplicate++;
            }
        }

        Arrays.stream(arr).forEach(System.out::println);
        // Return the length of the modified array (number of non-duplicate elements)
        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        Misc misc = new Misc();
        int val = misc.removeDuplices(new int[]{1, 1, 1, 2, 2, 5, 8, 9, 9});
        System.out.println("->" + val);
    }
}
