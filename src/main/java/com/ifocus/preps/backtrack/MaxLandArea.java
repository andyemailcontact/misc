package com.ifocus.preps.backtrack;


class MaxLandArea {
    public static void main(String[] args) {
        int[][] matrix =
                new int[][]{
                        {0, 1, 1, 1, 0},
                        {0, 0, 0, 1, 1},
                        {0, 1, 1, 1, 0},
                        {0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1}

                };
        System.out.println(new MaxLandArea().maxAreaOfIsland(matrix));
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;
        // each call will recursively call 4 neighboring grid. Call ends when grid is zero or out of bound
        return 1 + dfs(grid, i , j+1)
        + dfs(grid, i , j-1)
        +  dfs(grid, i+1, j)
        + dfs(grid, i-1, j);
    }

}
