class Solution {
    public int swimInWater(int[][] grid) {
        return solve(grid);
    }

    int solve(int[][] grid) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[2], b[2]));
        queue.add(new int[] { 0, 0, grid[0][0] });
        boolean [][] visited=new boolean [grid.length][grid[0].length];
        visited[0][0]=true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            int i = node[0];
            int j = node[1];
            int w = node[2];
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                return w;
            }
            int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
            for (int[] direction : directions) {
                int row = i + direction[0];
                int col = j + direction[1];
                if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length&&!visited[row][col]) {
                    queue.add(new int[] { row, col, Math.max(w, grid[row][col]) });
                    visited[row][col]=true;
                }
            }
        }
        return -1;
    }
}