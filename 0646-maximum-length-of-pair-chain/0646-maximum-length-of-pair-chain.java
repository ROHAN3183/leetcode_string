class Solution {
    int[][] memo;

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        memo = new int[pairs.length][2002];
        for (int i = 0; i < pairs.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(pairs, -1001, 0);

    }

    int dfs(int[][] pairs, int prev, int idx) {
        if (idx >= pairs.length) {
            return 0;
        }
        if (memo[idx][prev + 1001] != -1) {
            return memo[idx][prev + 1001];
        }
        int take = 0;
        int nottake = 0;
        if (pairs[idx][0] > prev) {
            take = 1 + dfs(pairs, pairs[idx][1], idx + 1);
        }
        nottake = dfs(pairs, prev, idx + 1);

        return memo[idx][prev + 1001] = Math.max(take, nottake);

    }
}