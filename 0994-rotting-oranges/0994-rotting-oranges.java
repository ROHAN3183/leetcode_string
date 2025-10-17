class Solution {

    class Pair {
        int i;
        int j;
        int time;

        Pair(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;

        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            int i = node.i;
            int j = node.j;
            int time = node.time;
            ans = Math.max(ans, time);
            if (j - 1 >= 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {//left
                visited[i][j - 1] = true;
                grid[i][j - 1] = 2;
                queue.offer(new Pair(i, j - 1, time + 1));
            }
            if (j + 1 < m && grid[i][j + 1] == 1 && !visited[i][j + 1]) {//right
                visited[i][j + 1] = true;
                grid[i][j + 1] = 2;
                queue.offer(new Pair(i, j + 1, time + 1));
            }
            if (i - 1 >= 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {//top
                visited[i - 1][j] = true;
                grid[i - 1][j] = 2;
                queue.offer(new Pair(i - 1, j, time + 1));
            }
            if (i + 1 < n && grid[i + 1][j] == 1 && !visited[i + 1][j]) {//bottom
                visited[i + 1][j] = true;
                grid[i + 1][j] = 2;
                queue.offer(new Pair(i + 1, j, time + 1));
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}