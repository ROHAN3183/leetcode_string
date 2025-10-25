class Solution {

    class Pair {
        int node;
        int dis;

        Pair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : times) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new Pair(v, w));
        }
        bfs(adj, distance, k, n);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(distance[i], max);
        }
        return max;

    }

    void bfs(ArrayList<ArrayList<Pair>> adj, int[] distance, int k, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.dis == b.dis) {
                return a.node - b.node;
            }
            return a.dis - b.dis;
        });
        pq.offer(new Pair(k, 0));
        distance[k] = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int i = curr.node;
            int j = curr.dis;
            if (j > distance[i])
                continue;
            for (Pair neighbour : adj.get(i)) {
                if (j + neighbour.dis < distance[neighbour.node]) {
                    distance[neighbour.node] = j + neighbour.dis;
                    pq.offer(new Pair(neighbour.node, j + neighbour.dis));
                }
            }
        }
        return;
    }

}