class Solution {
    int sum = 0;

    public int uniquePaths(int m, int n) {
        dfs(m, n, 0, 0);
        return sum;
    }

    void dfs(int m, int n, int row, int col) {
        if (row >= m || col >= n) {
            return;
        }

        if (row == m - 1 && col == n - 1) {
            sum++;
            return;
        }
        dfs(m, n, row + 1, col);
        dfs(m, n, row, col + 1);

        return;
    }
}