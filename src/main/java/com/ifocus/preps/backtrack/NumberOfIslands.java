package com.ifocus.preps.backtrack;

class NumberOfIslands {
    void dfs(int[][] grid, int row, int col) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (row < 0 || col < 0 || row >= nr || col >= nc || grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;
        // each call will recursively call 4 neighboring grid. Call ends when grid is zero or out of bound
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    public int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == 1) {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(
                new int[][] {
                        { 0, 1, 1, 1, 0 },
                        { 0, 0, 0, 1, 1 },
                        { 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }));

        System.out.println(new NumberOfIslands().numIslands(
                new int[][] {
                        { 1, 1, 1, 0, 0 },
                        { 0, 1, 0, 0, 1 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }));
    }
}

        
