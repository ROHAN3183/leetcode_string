class Solution {

    int startColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        startColor = image[sr][sc];
        if (image[sr][sc] != color) {
            dfs(image, sr, sc, color);
        }
        return image;

    }

    void dfs(int[][] image, int sr, int sc, int color) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }

        if (image[sr][sc] != startColor) {
            return;
        }
        image[sr][sc] = color;

        dfs(image, sr, sc + 1, color);
        dfs(image, sr, sc - 1, color);
        dfs(image, sr + 1, sc, color);
        dfs(image, sr - 1, sc, color);

        return;
    }
}