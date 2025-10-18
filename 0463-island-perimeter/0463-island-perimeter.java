class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    result = dfs(grid, i, j, visited);
                }
            }
        }
        return result;

    }

    int dfs(int[][] grid, int i, int j, boolean visited[][]) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 1;
        }
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;

        int left = dfs(grid, i, j - 1, visited);
        int right = dfs(grid, i, j + 1, visited);
        int top = dfs(grid, i - 1, j, visited);
        int bottom = dfs(grid, i + 1, j, visited);

        return left + right + top + bottom;

    }
}