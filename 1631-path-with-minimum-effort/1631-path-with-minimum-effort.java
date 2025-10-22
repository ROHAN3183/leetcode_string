class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int min = 0;
        int max = Integer.MAX_VALUE;
        int low = min;
        int high = max;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean[][] visited = new boolean[n][m];
            if (dfs(heights, visited, heights[0][0], 0, 0, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    boolean dfs(int[][] heights, boolean[][] visited, int prev, int i, int j, int target) {
        int n = heights.length;
        int m = heights[0].length;
        if (i >= n || i < 0 || j >= m || j < 0 || visited[i][j]) {
            return false;
        }
        if (Math.abs(prev - heights[i][j]) > target) {
            return false;
        }
        if (i == n - 1 && j == m - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean left = dfs(heights, visited, heights[i][j], i, j - 1, target);
        boolean right = dfs(heights, visited, heights[i][j], i, j + 1, target);
        boolean top = dfs(heights, visited, heights[i][j], i - 1, j, target);
        boolean bottom = dfs(heights, visited, heights[i][j], i + 1, j, target);

        return left || right || top || bottom;

    }
}