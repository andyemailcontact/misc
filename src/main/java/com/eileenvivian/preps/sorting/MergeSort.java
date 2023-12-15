package com.eileenvivian.preps.sorting;

import java.util.Arrays;

public class MergeSort {
    private static int[] combineSortedArrays(int[] arrayOne, int[] arrayTwo) {

        int arrayOneIndex = 0;
        int arrayTwoIndex = 0;
        int mergedArrayIndex = 0;
        int[] mergedArray = new int[arrayOne.length + arrayTwo.length];

        // both arrays have some items left in them.
        while (arrayOneIndex < arrayOne.length && arrayTwoIndex < arrayTwo.length) {

            // choose the smaller of the two items and add it to the
            // merged array.
            if (arrayOne[arrayOneIndex] <= arrayTwo[arrayTwoIndex]) {
                mergedArray[mergedArrayIndex] = arrayOne[arrayOneIndex];
                arrayOneIndex += 1;
            }
            else {
                mergedArray[mergedArrayIndex] = arrayTwo[arrayTwoIndex];
                arrayTwoIndex += 1;
            }
            mergedArrayIndex += 1;
        }

        // grab any lingering items in the first array after we've
        // exhausted the second array
        while (arrayOneIndex < arrayOne.length) {
            mergedArray[mergedArrayIndex] = arrayOne[arrayOneIndex];
            mergedArrayIndex += 1;
            arrayOneIndex += 1;
        }

        // grab any lingering items in the second array after we've
        // exhausted the first array
        while (arrayTwoIndex < arrayTwo.length) {
            mergedArray[mergedArrayIndex] = arrayTwo[arrayTwoIndex];
            mergedArrayIndex += 1;
            arrayTwoIndex += 1;
        }

        return mergedArray;
    }

    public static int[] mergeSort(int[] theArray) {

        // base case: single element array
        if (theArray.length <= 1) {
            return theArray;
        }

        // split the input in half
        int middleIndex = theArray.length / 2;
        int[] left  = Arrays.copyOfRange(theArray, 0, middleIndex);
        int[] right = Arrays.copyOfRange(theArray, middleIndex, theArray.length);

        // sort each half
        int[] leftSorted = mergeSort(left);
        int[] rightSorted = mergeSort(right);

        // merge the sorted halves
        return combineSortedArrays(leftSorted, rightSorted);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 4, 8, 3, 9};
        int[] sortArr = mergeSort(arr);
        Arrays.stream(sortArr).forEach(System.out::println);
    }
}
