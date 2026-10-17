class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int cost = edges[i][2];
            adj.get(u).add(new int[] { v, cost });
            adj.get(v).add(new int[] { u, cost });

        }
        for (int i = 0; i < n; i++) {
            Dijkistra(adj, i, distance[i]);
        }
        int global = Integer.MAX_VALUE;
        int node = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && distance[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= global) {
                global = count;
                node = i;
            }
        }
        return node;
    }

    void Dijkistra(List<List<int[]>> adj, int src, int[] distance) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1]));

        queue.add(new int[] { src, 0 });
        distance[src] = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int u = node[0];
            int cost = node[1];
            for (int[] neighbour : adj.get(u)) {
                int v = neighbour[0];
                int w = neighbour[1];
                if (distance[v] > cost + w) {
                    distance[v] = cost + w;
                    queue.add(new int[] { v, distance[v] });
                }
            }
        }
        return;
    }
}