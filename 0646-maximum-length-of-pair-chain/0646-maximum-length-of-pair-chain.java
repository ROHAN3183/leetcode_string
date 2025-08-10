class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        return dfs(pairs, Integer.MIN_VALUE, 0);

    }

    int dfs(int[][] pairs, int prev, int idx) {
        if (idx >= pairs.length) {
            return 0;
        }
        int take = 0;
        int nottake = 0;
        if (pairs[idx][0] > prev) {
            take = 1 + dfs(pairs, pairs[idx][1], idx + 1);
        }
        nottake = dfs(pairs, prev, idx + 1);

        return Math.max(take, nottake);

    }
}