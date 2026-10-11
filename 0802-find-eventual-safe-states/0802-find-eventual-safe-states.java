class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] recPath = new boolean[graph.length];
        boolean[] visited = new boolean[graph.length];
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int neighbour : graph[i]) {
                adj.get(i).add(neighbour);
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(adj, visited, recPath, i);
            }
        }
        for (int i = 0; i < recPath.length; i++) {
            if (!recPath[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    boolean dfs(List<List<Integer>> adj, boolean[] visited, boolean[] recPath, int source) {
        visited[source] = true;
        recPath[source] = true;
        for (int neighbour : adj.get(source)) {
            if (!visited[neighbour]) {
                if (dfs(adj, visited, recPath, neighbour)) {
                    return true;
                }
            } else if (recPath[neighbour]) {
                return true;
            }
        }
        recPath[source] = false;
        return false;
    }
}