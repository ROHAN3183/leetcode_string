class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
        ListNode temp = head;

        while (temp != null && left <= right && top <= bottom) {
            for (int i = left; i <= right && temp != null; i++) {
                matrix[top][i] = temp.val;
                temp = temp.next;
            }
            top++;
            for (int i = top; i <= bottom && temp != null; i++) {
                matrix[i][right] = temp.val;
                temp = temp.next;

            }
            right--;
            if (left <= right) {
                for (int i = right; i >= left && temp != null; i--) {
                    matrix[bottom][i] = temp.val;
                    temp = temp.next;
                }
            }
            bottom--;
            if (top <= bottom) {
                for (int i = bottom; i >= top && temp != null; i--) {
                    matrix[i][left] = temp.val;
                    temp = temp.next;
                }
            }
            left++;

        }
        return matrix;
    }
}