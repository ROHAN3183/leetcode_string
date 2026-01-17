class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    int dfs(int[][] matrix, int row, int col) {
        if (row >= matrix.length || row < 0 || col >= matrix[0].length || col < 0) {
            return 0;
        }
        int ans = 1;
        if (col - 1 >= 0 && matrix[row][col] < matrix[row][col - 1]) {
            ans = Math.max(ans, 1 + dfs(matrix, row, col - 1));
        }
        if (col + 1 <= matrix[0].length - 1 && matrix[row][col] < matrix[row][col + 1]) {
            ans = Math.max(ans, 1 + dfs(matrix, row, col + 1));
        }
        if (row + 1 <= matrix.length - 1 && matrix[row][col] < matrix[row + 1][col]) {
            ans = Math.max(ans, 1 + dfs(matrix, row + 1, col));
        }
        if (row - 1 >= 0 && matrix[row][col] < matrix[row - 1][col]) {
            ans = Math.max(ans, 1 + dfs(matrix, row - 1, col));
        }
        return ans;
    }
}