class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, dfs(grid, r, c));
                }
            }
        }
        return max;
    }

    int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return 0;
        }
        if (grid[r][c] == 0 || grid[r][c] == 2) {
            return 0;
        }

        grid[r][c] = 2;

        int left = dfs(grid, r, c - 1);
        int right = dfs(grid, r, c + 1);
        int top = dfs(grid, r - 1, c);
        int bottom = dfs(grid, r + 1, c);

        return 1 + left + right + top + bottom;
    }
}
