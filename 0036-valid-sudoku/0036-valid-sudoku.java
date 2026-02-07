class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, i, j, board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int i, int j, char target) {
        for (int row = 0; row < board.length; row++) {
            if (row == j) {
                continue;
            }
            if (board[i][row] == target) {
                return false;
            }
        }
        for (int col = 0; col < board.length; col++) {
            if (col == i) {
                continue;
            }
            if (board[col][j] == target) {
                return false;
            }
        }
        int row = (i / 3) * 3;
        int col = (j / 3) * 3;
        Set<Character> set = new HashSet<>();

        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                if(board[r][c]=='.'){
                    continue;
                }
                if (set.contains(board[r][c])) {
                    return false;
                }
                set.add(board[r][c]);
            }
        }
        return true;
    }
}