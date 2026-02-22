class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] pathvisited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathvisited)) {
                    return false;
                }
            }
        }
        return true;

    }

    boolean dfs(int start, List<List<Integer>> adj, boolean[] visited, boolean[] pathvisited) {
        visited[start] = true;
        pathvisited[start] = true;
        for (int neighbour : adj.get(start)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, adj, visited, pathvisited)) {
                    return true;
                }
            } else if (pathvisited[neighbour]) {
                return true;
            }
        }
        pathvisited[start] = false;
        return false;
    }
}