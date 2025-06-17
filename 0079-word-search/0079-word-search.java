class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int idx = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == word.charAt(0) && dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    boolean dfs(char[][] board, String word, int r, int c, int idx) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;

        }
        if (board[r][c] != word.charAt(idx)) {
            return false;
        }
        if (idx == word.length() - 1) {
            return true;
        }

        char temp = board[r][c];

        board[r][c] = '#';

        if (dfs(board, word, r + 1, c, idx + 1) || dfs(board, word, r - 1, c, idx + 1)
                || dfs(board, word, r, c + 1, idx + 1) || dfs(board, word, r, c - 1, idx + 1)) {
            return true;
        }
        board[r][c] = temp;
        return false;
    }
}