class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
            distance[i][i] = 0;
        }
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int cost = edges[i][2];

            distance[u][v] = cost;
            distance[v][u] = cost;
        }

        for (int k = 0; k < distance.length; k++) {
            for (int i = 0; i < distance.length; i++) {
                for (int j = 0; j < distance.length; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
        int global = Integer.MAX_VALUE;
        int node = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int newNode = i;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= global) {
                global = count;
                node = newNode;
            }
        }
        return node;
    }
}