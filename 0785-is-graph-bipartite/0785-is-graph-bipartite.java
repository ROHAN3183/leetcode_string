class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, color, i, 0)) {
                    return false;
                }

            }
        }
        return true;
    }

    boolean dfs(int[][] graph, int[] color, int source, int currColor) {
        color[source] = currColor;
        for (int neighbour : graph[source]) {
            if (color[neighbour] == -1) {
                if (!dfs(graph, color, neighbour, 1 - currColor)) {
                    return false;
                }
            } else if (color[neighbour] == color[source]) {
                return false;
            }
        }
        return true;
    }

}