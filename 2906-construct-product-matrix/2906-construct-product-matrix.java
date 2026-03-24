class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;
        int[] prefix = new int[n * m + 1];
        int[] suffix = new int[n * m + 1];

        prefix[0] = 1;
        suffix[suffix.length - 1] = 1;
        int idx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[idx] = (int) (((long) prefix[idx - 1] * grid[i][j]) % mod);
                idx++;
            }
        }
        idx = suffix.length - 2;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                suffix[idx] = (int) (((long) suffix[idx + 1] * grid[i][j]) % mod);
                idx--;
            }
        }

        idx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = (int) (((long) prefix[idx-1] * suffix[idx]) % mod);
                idx++;
            }
        }
        return grid;
    }
}