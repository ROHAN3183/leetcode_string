class Solution {
    public int numSubmat(int[][] mat) {
        int rowWise = 0;
        int matrixWise = 0;

        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            rowWise = rowWise + rowCount(row, mat[0].length);
        }

        for (int i = 0; i < mat.length - 1; i++) {
            int[] row = mat[i];
            matrixWise = matrixWise + dfs(mat, row, i + 1);
        }

        return matrixWise + rowWise;
    }

    int rowCount(int[] row, int length) {
        int totalCount = 0;
        int j = 0;
        while (j < length) {
            int count = 0;
            while (j < length && row[j] == 1) {
                count = count + 1;
                totalCount = totalCount + count;
                j++;
            }
            j++;
        }
        return totalCount;
    }

    int dfs(int[][] mat, int[] row, int j) {
        if (j >= mat.length) {
            return 0;
        }

        int[] newRow = new int[mat[0].length];
        for (int col = 0; col < mat[0].length; col++) {
            newRow[col] = row[col] & mat[j][col];
        }

        return rowCount(newRow, mat[0].length) + dfs(mat, newRow, j + 1);
    }
}
