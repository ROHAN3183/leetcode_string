class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            map.put(i, false);
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        dfs(adj, 0, visited, hasApple, map);
        for (boolean val : map.values()) {
            if (val) {
                count++;
            }
        }
        if (count * 2 - 2 <= 0) {
            return 0;
        }
        return count * 2 - 2;
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, List<Boolean> hasApple,
            HashMap<Integer, Boolean> map) {
        visited[i] = true;
        for (int neigbour : adj.get(i)) {
            if (!visited[neigbour]) {
                dfs(adj, neigbour, visited, hasApple, map);
            }
        }
        if (hasApple.get(i)) {
            map.put(i, true);
        } else {
            boolean hasAppleInNeighbor = false;
            for (int neighbor : adj.get(i)) {
                if (map.get(neighbor)) {
                    hasAppleInNeighbor = true;
                    break;
                }
            }
            map.put(i, hasAppleInNeighbor);

        }
        return;
    }
}