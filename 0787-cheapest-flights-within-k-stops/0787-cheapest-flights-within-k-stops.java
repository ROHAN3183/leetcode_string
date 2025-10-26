class Solution {
    class Pair {
        int node, cost;
        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    class Info {
        int node, cost, stops;
        Info(int node, int stops, int cost) {
            this.node = node;
            this.stops = stops;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : flights)
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));

        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(src, 0, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            Info cur = q.poll();

            if (cur.stops > k) continue;

            for (Pair nei : adj.get(cur.node)) {
                int newCost = cur.cost + nei.cost;
                if (newCost < dist[nei.node] && cur.stops <= k) {
                    dist[nei.node] = newCost;
                    q.offer(new Info(nei.node, cur.stops + 1, newCost));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}