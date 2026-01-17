class Solution {
    Integer[] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length];
        return dfs(arr, 0, k);
    }

    int dfs(int[] arr, int idx, int k) {
        if (idx >= arr.length) {
            return 0;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }

        int size = 1;
        int max = 0;
        int val=arr[idx];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = idx; size <= k && i < arr.length; i++) {
            val =Math.max(val,arr[i]);
            max = Math.max(max, (size * val) + dfs(arr, i + 1, k));
            size++;
        }
        return dp[idx] = max;
    }
}