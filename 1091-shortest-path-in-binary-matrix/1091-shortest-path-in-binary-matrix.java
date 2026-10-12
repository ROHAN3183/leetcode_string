class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        return Dijkistra(grid, distance);
    }

    int Dijkistra(int[][] grid, int[][] distance) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[2], b[2]));
        queue.add(new int[] { 0, 0, 1 });
        distance[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];
            int d = node[2];
            if (d > distance[i][j]) {
                continue;
            }
            if (i + 1 < grid.length && distance[i + 1][j] > d + 1 && grid[i + 1][j] == 0) {
                distance[i + 1][j] = d + 1;
                queue.add(new int[] { i + 1, j, distance[i + 1][j] });
            }

            if (i - 1 >= 0 && distance[i - 1][j] > d + 1 && grid[i - 1][j] == 0) {
                distance[i - 1][j] = d + 1;
                queue.add(new int[] { i - 1, j, distance[i - 1][j] });
            }

            if (j + 1 < grid[0].length && distance[i][j + 1] > d + 1 && grid[i][j + 1] == 0) {
                distance[i][j + 1] = d + 1;
                queue.add(new int[] { i, j + 1, distance[i][j + 1] });
            }

            if (j - 1 >= 0 && distance[i][j - 1] > d + 1 && grid[i][j - 1] == 0) {
                distance[i][j - 1] = d + 1;
                queue.add(new int[] { i, j - 1, distance[i][j - 1] });
            }

            if (i + 1 < grid.length && j + 1 < grid[0].length && distance[i + 1][j + 1] > d + 1
                    && grid[i + 1][j + 1] == 0) {
                distance[i + 1][j + 1] = d + 1;
                queue.add(new int[] { i + 1, j + 1, distance[i + 1][j + 1] });
            }

            if (i + 1 < grid.length && j - 1 >= 0 && distance[i + 1][j - 1] > d + 1 && grid[i + 1][j - 1] == 0) {
                distance[i + 1][j - 1] = d + 1;
                queue.add(new int[] { i + 1, j - 1, distance[i + 1][j - 1] });
            }

            if (i - 1 >= 0 && j + 1 < grid[0].length && distance[i - 1][j + 1] > d + 1 && grid[i - 1][j + 1] == 0) {
                distance[i - 1][j + 1] = d + 1;
                queue.add(new int[] { i - 1, j + 1, distance[i - 1][j + 1] });
            }

            if (i - 1 >= 0 && j - 1 >= 0 && distance[i - 1][j - 1] > d + 1 && grid[i - 1][j - 1] == 0) {
                distance[i - 1][j - 1] = d + 1;
                queue.add(new int[] { i - 1, j - 1, distance[i - 1][j - 1] });
            }
        }
        if (distance[distance.length - 1][distance[0].length - 1] == Integer.MAX_VALUE) {
            return -1;
        }

        return distance[distance.length - 1][distance[0].length - 1];
    }
}