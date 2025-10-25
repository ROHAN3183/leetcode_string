class Solution {
    class Pair {
        int node;
        int cst;

        Pair(int node, int cst) {
            this.node = node;
            this.cst = cst;
        }
    }

    int[][] memo;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] f : flights) adj.get(f[0]).add(new Pair(f[1], f[2]));

        memo = new int[n][k + 2];
        for (int[] row : memo) Arrays.fill(row, -1);

        int result = dfs(adj, src, dst, 0, k);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int dfs(ArrayList<ArrayList<Pair>> adj, int src, int dst, int stops, int k) {
        if (src == dst) return 0;
        if (stops > k) return Integer.MAX_VALUE;
        if (memo[src][stops] != -1) return memo[src][stops];

        int min = Integer.MAX_VALUE;
        for (Pair nei : adj.get(src)) {
            int next = dfs(adj, nei.node, dst, stops + 1, k);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, nei.cst + next);
            }
        }

        return memo[src][stops] = min;
    }
}
