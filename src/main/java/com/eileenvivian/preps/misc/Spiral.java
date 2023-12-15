package com.eileenvivian.preps.misc;

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
            if (isInvalid(matrix, row, col)) {
                row -= rowDir[dir];
                col -= colDir[dir];
                dir = (dir + 1) % 4;
                row += rowDir[dir];
                col += colDir[dir];
            }
        }
        return matrix;
    }
    private static boolean isInvalid(int[][] m, int r, int c) {
        return r<0||c<0||r>=m.length||c>= m[0].length||m[r][c] != 0;
    }

    public static void main(String[] args) {
        int[][] matrix = genSpiral(10, 5);
        System.out.println(matrix);
    }
}
