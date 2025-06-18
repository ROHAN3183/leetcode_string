class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    return dfs(grid, r, c);
                }
            }
        }
        return -1;

    }

    int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] == 2) {
            return 0;
        }
        grid[r][c] = 2;
        int left = dfs(grid, r, c - 1);
        int right = dfs(grid, r, c + 1);
        int top = dfs(grid, r - 1, c);
        int bottom = dfs(grid, r + 1, c);
        return left + right + top + bottom;
    }
}