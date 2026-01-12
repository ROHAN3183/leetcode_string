class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    result = Math.max(result, dfs(grid, visited, i, j));
                }
            }
        }
        return result;
    }

    int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || grid[row][col] == 0
                || visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        int left = grid[row][col] + dfs(grid, visited, row, col - 1);
        int right = grid[row][col] + dfs(grid, visited, row, col + 1);
        int top = grid[row][col] + dfs(grid, visited, row + 1, col);
        int bottom = grid[row][col] + dfs(grid, visited, row - 1, col);
        visited[row][col] = false;
        int max = Math.max(left, right);
        max = Math.max(max, Math.max(top, bottom));
        return max;

    }
}