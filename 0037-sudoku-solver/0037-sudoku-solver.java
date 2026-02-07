class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board);
        return;
    }

    boolean dfs(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = (char) k;
                            if (dfs(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int i, int j, char k) {
        for (int row = 0; row < board.length; row++) {
            if (board[i][row] == k) {
                return false;
            }
        }
        for (int col = 0; col < board.length; col++) {
            if (board[col][j] == k) {
                return false;
            }
        }
        int row = (i / 3) * 3;
        int col = (j / 3) * 3;
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                if (board[r][c] == k) {
                    return false;
                }
            }
        }
        return true;
    }

}