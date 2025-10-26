class Solution {
    final int MOD = (int) 1e9 + 7;

    class Pair {
        int node;
        long cost;

        Pair(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    long[] memo;

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        long[] distance = new long[n];
        memo = new long[n];
        Arrays.fill(memo, -1);
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : roads) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        Dijkstra(adj, distance);
        long result = dfs(adj, 0, n - 1, distance);
        return (int) result % MOD;
    }

    void Dijkstra(ArrayList<ArrayList<Pair>> adj, long[] distance) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        pq.offer(new Pair(0, 0L));
        distance[0] = 0L;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            long cost = curr.cost;
            if (cost > distance[node])
                continue;

            for (Pair nei : adj.get(node)) {
                if (cost + nei.cost < distance[nei.node]) {
                    distance[nei.node] = cost + nei.cost;
                    pq.offer(new Pair(nei.node, cost + nei.cost));
                }
            }
        }
    }

    long dfs(ArrayList<ArrayList<Pair>> adj, int src, int dst, long[] distance) {
        if (src == dst) {
            return 1;
        }
        if (memo[src] != -1) {
            return memo[src];
        }
        long path = 0L;
        for (Pair neibour : adj.get(src)) {
            if (distance[src] + neibour.cost == distance[neibour.node]) {
                path = (path + dfs(adj, neibour.node, dst, distance)) % MOD;
            }
        }
        return memo[src] = path;
    }

}
