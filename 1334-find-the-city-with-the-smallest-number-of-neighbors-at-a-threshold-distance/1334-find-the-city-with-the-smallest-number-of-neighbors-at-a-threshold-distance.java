
import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            adj.get(u).add(new int[] {v, cost});
            adj.get(v).add(new int[] {u, cost});
        }

        for (int i = 0; i < n; i++) {
            Dijkstra(adj, i, distance[i]);
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

    void Dijkstra(List<List<int[]>> adj, int src, int[] distance) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        queue.add(new int[] {src, 0});
        distance[src] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int u = current[0];
            int cost = current[1];

            if (cost > distance[u]) {
                continue;
            }

            for (int[] neighbour : adj.get(u)) {
                int v = neighbour[0];
                int w = neighbour[1];

                if (distance[v] > cost + w) {
                    distance[v] = cost + w;
                    queue.add(new int[] {v, distance[v]});
                }
            }
        }
    }
}
