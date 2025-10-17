class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<Pair> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        int OriginalColor=image[sr][sc];
        if(OriginalColor==color){
            return image;
        }
        queue.offer(new Pair(sr, sc));
        image[sr][sc]=color;
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            int i = node.i;
            int j = node.j;

            if (i - 1 >= 0 && image[i - 1][j] == OriginalColor && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                image[i - 1][j] = color;
                queue.offer(new Pair(i - 1, j));
            }
            if (i + 1 < n && image[i + 1][j] == OriginalColor && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                image[i + 1][j] = color;
                queue.offer(new Pair(i + 1, j));
            }
            if (j - 1 >= 0 && image[i][j - 1] == OriginalColor && !visited[i][j - 1]) {
                visited[i][j - 1] = true;
                image[i][j - 1] = color;
                queue.offer(new Pair(i, j - 1));
            }
            if (j + 1 < m && image[i][j + 1] == OriginalColor && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                image[i][j + 1] = color;
                queue.offer(new Pair(i, j + 1));
            }
        }
        return image;
    }
}