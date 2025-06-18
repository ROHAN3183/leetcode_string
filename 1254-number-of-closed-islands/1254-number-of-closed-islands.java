class Solution {
    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count=0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    if(dfs(grid, r, c)==1){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return 0;
        }
        if(grid[r][c]==1){
            return 1;
        }
        if (grid[r][c] == 2) {
            return 1;
        }
        grid[r][c] = 2;

        int bottom = dfs(grid, r + 1, c);
        int top = dfs(grid, r - 1, c);
        int right = dfs(grid, r, c + 1);
        int left = dfs(grid, r, c - 1);

        if(left==1 && right==1 &&top==1 &&bottom==1){
            return 1;
        }
        return 0;
    }
}