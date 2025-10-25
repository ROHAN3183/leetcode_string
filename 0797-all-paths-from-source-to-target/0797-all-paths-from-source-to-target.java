class Solution {
    List<List<Integer>> result;
    List<Integer> list;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        list = new ArrayList<>();
        result = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        dfs(graph, visited, 0);
        return result;
    }

    void dfs(int[][] graph, boolean[] visited, int i) {
        if (i == graph.length - 1) {
            list.add(i);
            result.add(new ArrayList<>(list));
            visited[i] = false;
            list.remove(list.size() - 1);
            return;
        }
        visited[i] = true;
        list.add(i);
        for (int neighbour : graph[i]) {
            if (!visited[neighbour]) {
                dfs(graph, visited, neighbour);
            }
        }
        visited[i] = false;
        list.remove(list.size() - 1);
        return;
    }
}