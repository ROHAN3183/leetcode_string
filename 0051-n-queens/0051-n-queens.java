class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> rowList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                rowList.add(".");
            }
            board.add(rowList);
        }
        result = new ArrayList<>();
        dfs(board, 0, n, n);
        return result;
    }
    void dfs(List<List<String>> board, int row, int n, int size) {
        if (row == size) {
            List<String> temp = new ArrayList<>();
            for (List<String> r : board) {
                temp.add(String.join("", r));
            }
            result.add(temp);
            return;
        }
        for (int col = 0; col < size; col++) {
            if (isValid(board, row, col)) {
                board.get(row).set(col, "Q");
                dfs(board, row + 1, n - 1, size);
                board.get(row).set(col, ".");
            }
        }
        return;
    }
    boolean isValid(List<List<String>> board, int row, int col) {
        for (int i = 0; i < board.get(0).size(); i++) {
            if (board.get(row).get(i).equals("Q")) {
                return false;
            }
        }
        for (int i = 0; i < board.get(0).size(); i++) {
            if (board.get(i).get(col).equals("Q")) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).get(j).equals("Q")) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.get(0).size(); i--, j++) {
            if (board.get(i).get(j).equals("Q")) {
                return false;
            }
        }
        return true;
    }
}
