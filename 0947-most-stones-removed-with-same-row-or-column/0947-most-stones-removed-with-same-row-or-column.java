class Solution {
    public int removeStones(int[][] stones) {

        int max1 = Integer.MIN_VALUE;
        int max0 = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < stones.length; i++) {
            max0 = Math.max(max0, stones[i][0]);
            max1 = Math.max(max1, stones[i][1]);
        }

        int n = Math.max(max1, max0)+1;
        int[][] matrix = new int[n][n];

        for (int i = 0; i < stones.length; i++) {
            int u = stones[i][0];
            int v = stones[i][1];
            matrix[u][v] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && (dfsLeft(matrix, i, j, j) || dfsRight(matrix, i, j + 1, j)
                        || dfsBottom(matrix, i, j, i) || dfsTop(matrix, i, j, i))) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
        }
        return stones.length - count;
    }

    boolean dfsLeft(int[][] matrix, int i, int j, int currj) {
        if (j < 0) {
            return false;
        }
        if (j != currj && matrix[i][j] == 1) {
            return true;
        }
        return dfsLeft(matrix, i, j - 1, currj);
    }

    boolean dfsRight(int[][] matrix, int i, int j, int currj) {
        if (j >= matrix[0].length) {
            return false;
        }
        if (j != currj && matrix[i][j] == 1) {
            return true;
        }
        return dfsRight(matrix, i, j + 1, currj);
    }

    boolean dfsTop(int[][] matrix, int i, int j, int curri) {
        if (i < 0) {
            return false;
        }
        if (i != curri && matrix[i][j] == 1) {
            return true;
        }
        return dfsTop(matrix, i - 1, j, curri);
    }

    boolean dfsBottom(int[][] matrix, int i, int j, int curri) {
        if (i >= matrix.length) {
            return false;
        }
        if (i != curri && matrix[i][j] == 1) {
            return true;
        }
        return dfsBottom(matrix, i + 1, j, curri);
    }

}