class Solution {
    Integer[] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[501];
        return dfs(arr, k, 0);
    }

    int dfs(int[] arr, int k, int idx) {
        if (idx >= arr.length) {
            return 0;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        int maxSum = 0;
        int result = 0;
        for (int j = idx; j < arr.length && j - idx + 1 <= k; j++) {
            maxSum = Math.max(maxSum, arr[j]);
            result = Math.max(result, (maxSum * (j - idx + 1)) + dfs(arr, k, j + 1));
        }
        return dp[idx] = result;
    }
}