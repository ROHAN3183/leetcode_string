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
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], w = flight[2];
            adj.get(u).add(new Pair(v, w));
        }

        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int result = dfs(adj, src, dst, 0, k);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int dfs(ArrayList<ArrayList<Pair>> adj, int src, int dst, int stops, int target) {

        if (src == dst)
            return 0;

        if (stops > target)
            return Integer.MAX_VALUE;

        if (memo[src][stops] != -1)
            return memo[src][stops];

        int min = Integer.MAX_VALUE;
        for (Pair neighbor : adj.get(src)) {
            int next = dfs(adj, neighbor.node, dst, stops + 1, target);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, neighbor.cst + next);
            }
        }

        memo[src][stops] = min;
        return min;
    }
}
