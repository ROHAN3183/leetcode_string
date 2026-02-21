class Solution {
    int ans = 0;

    public int countGoodNodes(int[][] edges) {
        List<List<Integer>> map = new ArrayList<>();

        for (int i = 0; i < edges.length + 1; i++) {
            List<Integer> list = new ArrayList<>();
            map.add(list);
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            map.get(u).add(v);
        }
        dfs(0, map);
        return ans;
    }

    int dfs(int start, List<List<Integer>> map) {
        if (map.get(start).size() <= 0) {
            ans++;
            return 1;
        }
        int count = 0;
        boolean flag = true;
        int prev = -1;
        for (Integer neighbour : map.get(start)) {
            int curr = dfs(neighbour, map);
            count += curr;
            if (prev == -1) {
                prev = curr;
            } else if (prev != curr) {
                flag = false;
            }
        }
        if (flag) {
            ans++;
        }
        return count + 1;
    }
}