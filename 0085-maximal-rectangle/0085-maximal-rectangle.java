
class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        int max_Area = 0;

        int[] firstRow = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    firstRow[j] += 1;
                } else {
                    firstRow[j] = 0;
                }
            }

            int[] NTL = nearestToLeft(firstRow, m);
            int[] NTR = nearestToRight(firstRow, m);

            for (int j = 0; j < m; j++) {
                int width = NTR[j] - NTL[j] - 1;
                int area = width * firstRow[j];
                max_Area = Math.max(max_Area, area);
            }
        }
        return max_Area;
    }

    private int[] nearestToLeft(int[] firstRow, int m) {
        Stack<Integer> stack = new Stack<>();
        int[] NSL = new int[m];

        for (int i = 0; i < m; i++) {
            while (!stack.isEmpty() && firstRow[stack.peek()] >= firstRow[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                NSL[i]=-1;
            }
            else{
                NSL[i]=stack.peek();
            }
            stack.push(i);
        }
        return NSL;
    }

    private int[] nearestToRight(int[] firstRow, int m) {
        Stack<Integer> stack = new Stack<>();
        int[] NSR = new int[m];

        for (int i = m - 1; i >= 0; i--) {
            while (!stack.isEmpty() && firstRow[stack.peek()] >= firstRow[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                NSR[i]=m;
            }
            else{
                NSR[i]=stack.peek();
            }

            stack.push(i);
        }
        return NSR;
    }
}
