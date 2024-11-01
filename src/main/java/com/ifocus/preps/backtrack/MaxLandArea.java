package com.ifocus.preps.backtrack;


class MaxLandArea {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1)
                    maxArea = Math.max(maxArea, dfs(grid,i,j));
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;
        int count = 1;
        // each call will recursively call 4 neighboring grid. Call ends when grid is zero or out of bound
        count += dfs(grid, i , j+1);
        count += dfs(grid, i , j-1);
        count += dfs(grid, i+1, j);
        count += dfs(grid, i-1, j);

        return count;
    }

}
