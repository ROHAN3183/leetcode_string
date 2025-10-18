class Solution {
    boolean isValid;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    isValid = true;
                    dfs(grid1, grid2, visited, i, j);
                    if (isValid) {
                        count++;
                    }

                }
            }
        }
        return count;

    }

    void dfs(int[][] grid1, int[][] grid2, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length || grid2[i][j] == 0 || visited[i][j]) {
            return;
        }
        if (grid2[i][j] == 1 && grid1[i][j] == 0) {
            isValid = false;
        }
        visited[i][j] = true;

        dfs(grid1, grid2, visited, i + 1, j);
        dfs(grid1, grid2, visited, i - 1, j);
        dfs(grid1, grid2, visited, i, j - 1);
        dfs(grid1, grid2, visited, i, j + 1);

        return;

    }
}