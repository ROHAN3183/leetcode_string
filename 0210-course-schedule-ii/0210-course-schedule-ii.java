class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        Stack<Integer> stack = new Stack();
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

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, stack, recPath)) {
                    return new int[0];
                }
            }
        }

        int[] result = new int[stack.size()];

        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    boolean dfs(int source, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack, boolean[] recPath) {
        visited[source] = true;
        recPath[source] = true;
        for (Integer neighbour : adj.get(source)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, adj, visited, stack, recPath)) {
                    return true;
                }
            } else if (recPath[neighbour]) {
                return true;
            }
        }
        recPath[source] = false;
        stack.push(source);
        return false;
    }
}
