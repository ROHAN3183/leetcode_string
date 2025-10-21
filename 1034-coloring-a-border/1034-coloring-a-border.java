class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];

        bfs(grid, queue, row, col, color, result);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == 0) {
                    int val = grid[i][j];
                    result[i][j] = val;
                }
            }
        }
        return result;

    }

    void bfs(int[][] grid, Queue<Pair> queue, int row, int col, int newColor, int[][] result) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int targetColor = grid[row][col];
        queue.offer(new Pair(row, col));
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            int i = node.i;
            int j = node.j;

            boolean left = true;
            boolean top = true;
            boolean right = true;
            boolean bottom = true;

            if (i - 1 < 0 || grid[i - 1][j] != targetColor) {
                top = !top;
            }
            if (i + 1 >= n || grid[i + 1][j] != targetColor) {
                bottom = !bottom;
            }
            if (j - 1 < 0 || grid[i][j - 1] != targetColor) {
                left = !left;
            }
            if (j + 1 >= m || grid[i][j + 1] != targetColor) {
                right = !right;
            }

            if (!top || !bottom || !left || !right) {
                result[i][j] = newColor;
            }

            if (i - 1 >= 0 && grid[i - 1][j] == targetColor && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                queue.offer(new Pair(i - 1, j));
            }
            if (i + 1 < n && grid[i + 1][j] == targetColor && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                queue.offer(new Pair(i + 1, j));
            }
            if (j - 1 >= 0 && grid[i][j - 1] == targetColor && !visited[i][j - 1]) {
                visited[i][j - 1] = true;
                queue.offer(new Pair(i, j - 1));
            }
            if (j + 1 < m && grid[i][j + 1] == targetColor && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                queue.offer(new Pair(i, j + 1));
            }

        }
        return;

    }
}