
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int components = n;

        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            if (rootU != rootV) {
                union(parent, rank, rootU, rootV);
                components--;
            }
        }

        return components - 1;
    }

    int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    void union(int[] parent, int[] rank, int rootU, int rootV) {
        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }
}
