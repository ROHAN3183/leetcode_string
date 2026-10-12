class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] distance = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        return Dijkistra(heights, distance);
    }

    int Dijkistra(int[][] heights, int[][] distance) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[2], b[2]));

        queue.add(new int[] { 0, 0, 0 });
        distance[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];
            int d = node[2];

            if (i + 1 < heights.length
                    && distance[i + 1][j] > Math.max(d, Math.abs(heights[i][j] - heights[i + 1][j]))) {
                distance[i + 1][j] = Math.max(d, Math.abs(heights[i][j] - heights[i + 1][j]));
                queue.add(new int[] { i + 1, j, distance[i + 1][j] });
            }

            if (i - 1 >= 0 && distance[i - 1][j] > Math.max(d, Math.abs(heights[i][j] - heights[i - 1][j]))) {
                distance[i - 1][j] = Math.max(d, Math.abs(heights[i][j] - heights[i - 1][j]));
                queue.add(new int[] { i - 1, j, distance[i - 1][j] });
            }

            if (j + 1 < heights[0].length
                    && distance[i][j + 1] > Math.max(d, Math.abs(heights[i][j] - heights[i][j + 1]))) {
                distance[i][j + 1] = Math.max(d, Math.abs(heights[i][j] - heights[i][j + 1]));
                queue.add(new int[] { i, j + 1, distance[i][j + 1] });
            }

            if (j - 1 >= 0 && distance[i][j - 1] > Math.max(d, Math.abs(heights[i][j] - heights[i][j - 1]))) {
                distance[i][j - 1] = Math.max(d, Math.abs(heights[i][j] - heights[i][j - 1]));
                queue.add(new int[] { i, j - 1, distance[i][j - 1] });
            }
        }
        return distance[heights.length - 1][distance[0].length - 1];
    }
}