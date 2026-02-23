class Solution {
    Set<Integer> set;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        set = new HashSet<>();
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        List<Integer> result = new ArrayList<>();
        boolean[] pathvisited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            int size = graph[i].length;
            for (int neighbour : graph[i]) {
                adj.get(i).add(neighbour);
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, pathvisited);
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    boolean dfs(int start, List<List<Integer>> adj, boolean[] visited, boolean[] pathvisited) {
        visited[start] = true;
        pathvisited[start] = true;
        for (int neighbour : adj.get(start)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, adj, visited, pathvisited)) {
                    for (int i = 0; i < pathvisited.length; i++) {
                        if (pathvisited[i]) {
                            set.add(i);
                        }
                    }
                    return true;
                }
            } else if (pathvisited[neighbour]) {
                for (int i = 0; i < pathvisited.length; i++) {
                    if (pathvisited[i]) {
                        set.add(i);
                    }
                }
                return true;
            }
        }
        pathvisited[start] = false;
        return false;
    }
}