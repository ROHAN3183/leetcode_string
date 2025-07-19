class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int countOfOnes = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < row; i++) {
            Arrays.sort(mat[i]);
        }

        for (int i = 0; i < row; i++) {
            int count = countOfOnes(mat[i]);
            if (count > countOfOnes) {
                countOfOnes = count;
                index = i;
            }
        }
        return new int[] { index, countOfOnes };
    }

    int countOfOnes(int[] mat) {
        int low = 0;
        int high = mat.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mat[mid] >= 1) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (ans == -1) {
            return 0;
        }
        return mat.length - ans;
    }
}