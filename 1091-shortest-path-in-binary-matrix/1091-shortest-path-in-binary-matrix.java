class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        return bfs(grid, visited, queue, 0, 0);
    }

    int bfs(int[][] grid, boolean[][] visited, Queue<Pair> queue, int i0, int j0) {
        int n = grid.length;

        if (grid[i0][j0] == 0 && !visited[i0][j0]) {
            visited[i0][j0] = true;
            queue.offer(new Pair(i0, j0));
        }
        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                Pair node = queue.poll();
                int i = node.i;
                int j = node.j;

                if (i == n - 1 && j == n - 1) {
                    return step;
                }

                if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == 0) {
                    visited[i - 1][j] = true;
                    queue.offer(new Pair(i - 1, j));
                }
                if (i + 1 < n && !visited[i + 1][j] && grid[i + 1][j] == 0) {
                    visited[i + 1][j] = true;
                    queue.offer(new Pair(i + 1, j));
                }
                if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == 0) {
                    visited[i][j - 1] = true;
                    queue.offer(new Pair(i, j - 1));
                }
                if (j + 1 < n && !visited[i][j + 1] && grid[i][j + 1] == 0) {
                    visited[i][j + 1] = true;
                    queue.offer(new Pair(i, j + 1));
                }
                if (i + 1 < n && j + 1 < n && !visited[i + 1][j + 1] && grid[i + 1][j + 1] == 0) {
                    visited[i + 1][j + 1] = true;
                    queue.offer(new Pair(i + 1, j + 1));
                }
                if (i - 1 >= 0 && j - 1 >= 0 && !visited[i - 1][j - 1] && grid[i - 1][j - 1] == 0) {
                    visited[i - 1][j - 1] = true;
                    queue.offer(new Pair(i - 1, j - 1));
                }
                if (i - 1 >= 0 && j + 1 < n && !visited[i - 1][j + 1] && grid[i - 1][j + 1] == 0) {
                    visited[i - 1][j + 1] = true;
                    queue.offer(new Pair(i - 1, j + 1));
                }
                if (i + 1 < n && j - 1 >= 0 && !visited[i + 1][j - 1] && grid[i + 1][j - 1] == 0) {
                    visited[i + 1][j - 1] = true;
                    queue.offer(new Pair(i + 1, j - 1));
                }
            }
            step++;
        }
        return -1;
    }
}
