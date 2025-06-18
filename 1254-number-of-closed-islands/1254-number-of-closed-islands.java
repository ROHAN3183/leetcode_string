class Solution {
    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    if (dfs(grid, r, c)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    boolean dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return false;
        }

        if (grid[r][c] == 1) {
            return true;
        }

        if (grid[r][c] == 2) {
            return true;
        }

        grid[r][c] = 2;

        boolean bottom = dfs(grid, r + 1, c);
        boolean top = dfs(grid, r - 1, c);
        boolean right = dfs(grid, r, c + 1);
        boolean left = dfs(grid, r, c - 1);

        return bottom && top && right && left;
    }
}
