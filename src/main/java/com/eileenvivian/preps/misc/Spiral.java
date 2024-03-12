package com.eileenvivian.preps.misc;

import java.util.Arrays;

public class Spiral {
    public static int[][] genSpiral(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int[] rowDir = {0, 1, 0, -1};
        int[] colDir = {1, 0, -1, 0};
        int total = rows * cols;
        int num = 0;
        int dir=0;
        int row=0, col=0;
        while (num++ < total) {
            matrix[row][col] = num;
            row += rowDir[dir];
            col += colDir[dir];
            if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] != 0) {
                row -= rowDir[dir];
                col -= colDir[dir];
                dir = (dir + 1) % 4;
                row += rowDir[dir];
                col += colDir[dir];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = genSpiral(10, 5);
        for(int[] row : matrix) {
            for(int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
