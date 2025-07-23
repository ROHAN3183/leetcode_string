class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m= matrix[0].length;
        int min = Integer.MAX_VALUE;
        int [][] dp =new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, dfs(matrix, 0, i,dp));
        }
        return min;
    }

    int dfs(int[][] matrix, int row, int col ,int [][] dp) {
        if (col < 0 || col >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }

        if (row == matrix.length - 1) {
            return matrix[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int result = matrix[row][col];
        int min = Integer.MAX_VALUE;

        for (int i = -1; i <= 1; i++) {
            min = Math.min(min, dfs(matrix, row + 1, col + i , dp));
        }

        result += min;
        dp[row][col]=result;
        return result;
    }
}
