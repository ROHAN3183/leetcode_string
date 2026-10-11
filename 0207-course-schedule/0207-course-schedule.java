class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] recPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
        }
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                if (isCycle(adj, visited, i, recPath)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isCycle(List<List<Integer>> adj, boolean[] visited, int source, boolean[] recPath) {
        visited[source] = true;
        recPath[source] = true;
        for (int neighbour : adj.get(source)) {
            if (!visited[neighbour]) {
                if (isCycle(adj, visited, neighbour, recPath)) {
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