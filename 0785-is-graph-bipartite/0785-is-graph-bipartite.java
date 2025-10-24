class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        for (int i = 0; i < graph.length; i++) {
            if (i == 0) {
                visited[i] = 0;
            }
            if (!dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int[][] graph, int[] visited, int i) {

        for (int neighbour : graph[i]) {
            if (visited[neighbour] == -1) {
                visited[neighbour] = 1 - visited[i];
                if (!dfs(graph, visited, neighbour)) {
                    return false;
                }
            } else if (visited[neighbour] == visited[i]) {
                return false;
            }
        }
        return true;
    }
}