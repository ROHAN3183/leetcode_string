class Solution {
    public int[][] updateMatrix(int[][] mat) {
        return bfs(mat);
    }

    int[][] bfs(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int[][] result = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j, 0 });
                    visited[i][j] = true;
                    result[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];
            int count = node[2];
            if (i + 1 < mat.length && !visited[i + 1][j]) {
                queue.add(new int[] { i + 1, j, count + 1 });
                visited[i + 1][j] = true;
                result[i + 1][j] = count + 1;
            }
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                queue.add(new int[] { i - 1, j, count + 1 });
                visited[i - 1][j] = true;
                result[i - 1][j] = count + 1;
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                queue.add(new int[] { i, j - 1, count + 1 });
                visited[i][j - 1] = true;
                result[i][j - 1] = count + 1;
            }
            if (j + 1 < mat[0].length && !visited[i][j + 1]) {
                queue.add(new int[] { i, j + 1, count + 1 });
                visited[i][j + 1] = true;
                result[i][j + 1] = count + 1;
            }

        }
        return result;
    }
}