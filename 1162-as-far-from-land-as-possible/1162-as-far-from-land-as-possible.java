class Solution {
    class Pair {
        int i;
        int j;
        int distance;

        Pair(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1 && !visited[i][j]){
                    visited[i][j]=true;
                    queue.offer(new Pair(i,j,0));
                }
            }
        }
        if(queue.size()==0||queue.size()==n*n){
            return -1;
        }
        return bfs(grid,visited,queue);

    }

    int bfs(int[][] grid, boolean[][] visited, Queue<Pair> queue) {
        int max = 0;
        int n = grid.length;
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            int i = node.i;
            int j = node.j;
            int distance = node.distance;
            max = Math.max(distance, max);
            if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == 0) {
                visited[i - 1][j] = true;
                queue.offer(new Pair(i - 1, j, distance + 1));
            }
            if (i + 1 < n && !visited[i + 1][j] && grid[i + 1][j] == 0) {
                visited[i + 1][j] = true;
                queue.offer(new Pair(i + 1, j, distance + 1));
            }
            if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == 0) {
                visited[i][j - 1] = true;
                queue.offer(new Pair(i, j - 1, distance + 1));
            }
            if (j + 1 < n && !visited[i][j + 1] && grid[i][j + 1] == 0) {
                visited[i][j + 1] = true;
                queue.offer(new Pair(i, j + 1, distance + 1));
            }

        }
        return max;
    }
}