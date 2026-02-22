class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        Stack<Integer> stack = new Stack();
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
                if (dfs(i, adj, visited, stack, pathvisited)) {
                    return new int[0];
                }
            }
        }

        int[] result = new int[stack.size()];

        if (stack.size() < numCourses) {
            return result;
        }
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    boolean dfs(int start, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack, boolean[] pathvisited) {
        visited[start] = true;
        pathvisited[start] = true;
        for (Integer neighbour : adj.get(start)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, adj, visited, stack, pathvisited)) {
                    return true;
                }
            } else if (pathvisited[neighbour]) {
                return true;
            }
        }
        pathvisited[start] = false;
        stack.push(start);
        return false;
    }
}