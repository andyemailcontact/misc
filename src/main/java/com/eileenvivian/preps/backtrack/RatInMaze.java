package com.eileenvivian.preps.backtrack;

public class RatInMaze {
    final int N = 4;

    /* A utility function to print solution matrix
       sol[N][N] */
    void printSolution(int sol[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    /* A utility function to check if x, y is valid
        index for N*N maze */
    boolean isSafe(int maze[][], int x, int y)
    {
        // if (x, y outside maze) return false
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    boolean solveMaze(int maze[][])
    {
        int sol[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

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
                      int sol[][])
    {
        // if (x, y is goal) return true
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }
        int[] xCoord = {1, 0};
        int[] yCoord = {0, 1};
        if (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1) {
            sol[x][y] = 1;
            for (int i=0; i<4; i++) {
                // mark x, y as part of solution path

                /* Move forward in x direction */
                if (backtrack(maze, x + xCoord[i], y + yCoord[i], sol))
                    return true;
            }
            sol[x][y] = 0;
        }
        return false;
    }

    public static void main(String args[])
    {
        RatInMaze rat = new RatInMaze();
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };
        rat.solveMaze(maze);
    }
}
