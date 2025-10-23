class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        return dfs(adj, 0, visited, hasApple);

    }

    int dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, List<Boolean> hasApple) {
        visited[i] = true;
        int time = 0;
        for (int neigbour : adj.get(i)) {
            if (!visited[neigbour]) {
                int childTime = dfs(adj, neigbour, visited, hasApple);
                if (childTime > 0 || hasApple.get(neigbour)) {
                    time += childTime + 2;
                }
            }
        }

        return time;
    }
}