package com.eileenvivian.preps.topk;

import java.util.*;

class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. Build hash map: character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap<>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. Keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.offer(n);
            // lop off smallest
            if (heap.size() > k) heap.poll();
        }

        // 3. Build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 4, 4, 1, 5, 1, 5, 4};
        int[] tops = topKFrequent(nums, 2);
        Arrays.stream(tops).forEach(System.out::println);
    }
}
