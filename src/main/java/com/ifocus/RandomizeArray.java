package com.ifocus;

import java.util.Arrays;
import java.util.Random;

public class RandomizeArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        shuffleArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            // random between 0 and all number to the left (0 inclusive to exclusive input)
            int index = random.nextInt(i + 1);
            // Swap elements
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
