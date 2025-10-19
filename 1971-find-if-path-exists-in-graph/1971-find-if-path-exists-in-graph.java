class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> Adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            Adj.get(u).add(u);
            Adj.get(v).add(u);

        }
        if (!visited[source]) {
            dfs(Adj, source, visited);
        }
        return visited[destination];
    }

    void dfs(ArrayList<ArrayList<Integer>> Adj, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighour : Adj.get(node)) {
            if (!visited[neighour]) {
                dfs(Adj, neighour, visited);
            }
        }
    }
}