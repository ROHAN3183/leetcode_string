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
        int sum = 0;
        int size = 1;
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = idx; size <= k && i < arr.length; i++) {
            pq.offer(arr[i]);
            int val = pq.peek();
            max = Math.max(max, (size * val) + dfs(arr, i + 1, k));
            size++;
        }
        return dp[idx] = max;
    }
}