package com.eileenvivian.preps.graph;

// Java program to print BFS traversal from a given source
// vertex. BFS(int s) traverses vertices reachable from s.

import java.util.Iterator;
import java.util.LinkedList;

// This class represents a directed graph using adjacency
// list representation
class Graph {
    // No. of vertices
    private int numVertices;

    // Adjacency Lists
    private LinkedList<Integer>[] adj;

    // Constructor
    Graph(int vertNum) {
        numVertices = vertNum;
        adj = new LinkedList[vertNum];
        for (int i = 0; i < vertNum; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int vertice, int neighbor) {
        adj[vertice].add(neighbor);
    }

    // prints BFS traversal from a given source node
    void BFS(int node) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[numVertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[node] = true;
        queue.add(node);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            node = queue.poll();
            System.out.print(node + " ");

            // Get all adjacent vertices of the dequeued
            // vertex node.
            // If an adjacent has not been visited,
            // then mark it visited and enqueue it
            Iterator<Integer> i = adj[node].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Driver code
    public static void main(String args[])
    {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Breadth First Traversal "
                        + "(starting from vertex 2)");

        g.BFS(2);
    }
}

// This code is contributed by Aakash Hasija

