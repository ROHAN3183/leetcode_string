class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    continue;
                } else if (board[i][j] == 'O' && dfs1(board, i - 1, j) && dfs2(board, i + 1, j)
                        && dfs3(board, i, j - 1) && dfs4(board, i, j + 1)) {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }

    boolean dfs1(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (board[i][j] == 'X')
            return true;

        board[i][j] = '#';
        boolean res = dfs1(board, i - 1, j);
        board[i][j] = 'O';
        return res;
    }

    boolean dfs2(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (board[i][j] == 'X')
            return true;
        board[i][j] = '#';
        boolean res = dfs2(board, i + 1, j);
        board[i][j] = 'O';
        return res;
    }

    boolean dfs3(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (board[i][j] == 'X')
            return true;
        board[i][j] = '#';
        boolean res = dfs3(board, i, j - 1);
        board[i][j] = 'O';
        return res;
    }

    boolean dfs4(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (board[i][j] == 'X')
            return true;
        board[i][j] = '#';
        boolean res = dfs4(board, i, j + 1);
        board[i][j] = 'O';
        return res;
    }
}
