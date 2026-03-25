class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] colSum = new int[m];
        int[] rowSum = new int[n];
        long totalcolSum = 0;
        long totalrowSum = 0;
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum += grid[j][i];
            }
            colSum[i] = (int) sum;
            totalcolSum += sum;
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < m; j++) {
                sum += grid[i][j];
            }
            rowSum[i] = (int) sum;
            totalrowSum += sum;
        }
        long sum = 0;
        for (int i = 0; i < colSum.length - 1; i++) {
            sum += colSum[i];
            if (totalcolSum - 2 * sum == 0) {
                return true;
            }
        }
        sum = 0;
        for (int i = 0; i < rowSum.length - 1; i++) {
            sum += rowSum[i];
            if (totalrowSum - 2 * sum == 0) {
                return true;
            }
        }
        return false;
    }
}