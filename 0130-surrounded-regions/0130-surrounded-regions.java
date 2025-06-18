class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // left to right
         for (int c = 0; c < n; c++) {
        if (board[0][c] == 'O') {
            dfs(board, 0, c);
        }
    }

    // bottom row
    for (int c = 0; c < n; c++) {
        if (board[m - 1][c] == 'O') {
            dfs(board, m - 1, c);
        }
    }

    // left column
    for (int r = 0; r < m; r++) {
        if (board[r][0] == 'O') {
            dfs(board, r, 0);
        }
    }

    // right column
    for (int r = 0; r < m; r++) {
        if (board[r][n - 1] == 'O') {
            dfs(board, r, n - 1);
        }
    }

        // final result
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'B') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }
        if (board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'B';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
