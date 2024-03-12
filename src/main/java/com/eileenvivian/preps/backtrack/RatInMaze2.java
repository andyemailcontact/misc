package com.eileenvivian.preps.backtrack;

public class RatInMaze2 {
    final int N = 4;

    /* A utility function to print solution matrix
       sol[N][N] */
    void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    /* A utility function to check if x, y is valid
        index for N*N maze */
    boolean isSafe(int maze[][], int x, int y) {
        // if (x, y outside maze) return false
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    boolean solveMaze(int maze[][]) {
        int sol[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        if (backtrack(maze, 0, 0, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    /* A recursive utility function to solve Maze
       problem */
    boolean backtrack(int maze[][], int x, int y,
                      int sol[][]) {
        // if (x, y is goal) return true
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (x < 0 || x >= N || y < 0 || y >= N || maze[x][y] == 0) {
            return false;
        }

        // mark x, y as part of solution path
        sol[x][y] = 1;

        /* Move forward in x direction */
        if (backtrack(maze, x + 1, y, sol))
            return true;
        /* move down */
        if (backtrack(maze, x, y + 1, sol))
            return true;

        sol[x][y] = 0;
        return false;
    }

    public static void main(String args[]) {
        RatInMaze2 rat = new RatInMaze2();
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        rat.solveMaze(maze);
    }
}
