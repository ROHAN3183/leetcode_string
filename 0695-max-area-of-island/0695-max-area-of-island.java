class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        Queue<Pair> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, bfs(grid, visited, queue, i, j));
                }
            }
        }
        return max;

    }

    int bfs(int[][] grid, boolean[][] visited, Queue<Pair> queue, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;
        queue.offer(new Pair(row, col));
        visited[row][col] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            int i = node.i;
            int j = node.j;
            if (i - 1 >= 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {//top
                visited[i - 1][j] = true;
                queue.offer(new Pair(i - 1, j));
            }
            if (i + 1 < n && grid[i + 1][j] == 1 && !visited[i + 1][j]) {//bottom
                visited[i + 1][j] = true;
                queue.offer(new Pair(i + 1, j));
            }
            if (j - 1 >= 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {//left
                visited[i - 1][j] = true;
                queue.offer(new Pair(i, j - 1));
            }
            if (j + 1 < m && grid[i][j + 1] == 1 && !visited[i][j + 1]) {//right
                visited[i][j + 1] = true;
                queue.offer(new Pair(i, j + 1));
            }
            count++;
        }
        return count;
    }
}