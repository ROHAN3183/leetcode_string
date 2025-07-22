class Solution {
    public int minPathSum(int[][] grid) {
        return dfs(grid, 0, 0);

    }

    int dfs(int [][] grid , int row ,int col ){
        if(row >=grid.length||col>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }
        int down =dfs(grid,row+1,col);
        int right =dfs(grid,row,col+1);
        return grid[row][col] + Math.min(down ,right);

    }
}