class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        return bfs(graph, visited, queue);
    }

    boolean bfs(int[][] graph, int[] visited, Queue<Integer> queue) {
        queue.offer(0);
        visited[0] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neibour : graph[node]) {
                if (visited[neibour] == -1) {
                    visited[neibour] = 1 - visited[node];
                    queue.offer(neibour);
                } else if (visited[neibour] == visited[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}