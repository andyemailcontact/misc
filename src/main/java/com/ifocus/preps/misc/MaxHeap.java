package com.ifocus.preps.misc;

// Java program to implement Max Heap

// Main class
public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxsize;

    // Constructor to initialize an
    // empty max heap with given maximum
    // capacity
    public MaxHeap(int maxsize) {
        // This keyword refers to current instance itself
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[this.maxsize];
    }

    // Returning position of parent
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    // Returning left children
    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    // Returning right children
    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    // Returning true if given node is leaf
    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Swapping nodes
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    // Recursive function to max heapify given subtree
    // start at index 'pos', if children is larger, swap with the larger child and recurse on that node
    private void maxHeapify(int pos) {
        if (isLeaf(pos))
            return;

        if (heap[pos] < heap[leftChild(pos)]
                || heap[pos] < heap[rightChild(pos)]) {

            if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    // Inserts a new element to max heap
    /// insert to the end (right most) and propagate up until satisfies with parent node
    public void insert(int element) {
        heap[size] = element;

        // Traverse up and fix violated property
        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    // To display heap
    public void print() {

        for (int i = 0; i < size / 2; i++) {

            System.out.print("Parent Node : " + heap[i]);

            if (leftChild(i)
                    < size) // if the child is out of the bound
                // of the array
                System.out.print(" Left Child Node: "
                        + heap[leftChild(i)]);

            if (rightChild(i)
                    < size) // the right child index must not
                // be out of the index of the array
                System.out.print(" Right Child Node: "
                        + heap[rightChild(i)]);

            System.out.println(); // for new line
        }
    }

    // Remove an element from max heap
    // take top off, then take the last node value and heapify
    public int extractMax() {
        int popped = heap[0];
        heap[0] = heap[--size];
        maxHeapify(0);
        return popped;
    }

    // Method 10
    // main driver method
    public static void main(String[] arg) {
        // Display message for better readability
        System.out.println("The Max Heap is ");

        MaxHeap maxHeap = new MaxHeap(15);

        // Inserting nodes
        // Custom inputs
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        // Calling maxHeap() as defined above
        maxHeap.print();

        // Print and display the maximum value in heap
        System.out.println("The max val is " + maxHeap.extractMax());
    }
}

