class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = grid.length;
        int m = grid[0].length;
        int total = m * n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }
        int repeated = -1;
        int missing = -1;
        for (int i = 1; i <= total; i++) {
            if (map.containsKey(i) && map.get(i) > 1) {
                repeated = i;
            }
            if (!map.containsKey(i)) {
                missing = i;
            }
        }
        return new int[] { repeated, missing };
    }
}