package com.eileenvivian.preps.topk;

import java.util.*;

class KthLowest {
    public static int getLowest(int[] nums, int k) {

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b-a);

        // 2. Keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: nums) {
            heap.offer(n);
            System.out.println("queue: " + heap);
            // lop off smallest
            if (heap.size() > k) {
                heap.poll();
            }
            System.out.println("queue: " + heap);
        }

        return heap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = getLowest(nums, 2);
        System.out.println("k=" + k);
    }
}
