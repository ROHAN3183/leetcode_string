class Solution {
    int min;
    int max;

    public int kthSmallest(int[][] matrix, int k) {

        findMinAndMax(matrix);

        int low = min;
        int high = max;
        int result = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int smallestCount = 0;

            for (int i = 0; i < matrix.length; i++) {
                smallestCount = smallestCount + numberOfSmallest(matrix[i], mid);
            }

            if (smallestCount >= k) {
                result = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return result;

    }

    void findMinAndMax(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            min = Math.min(matrix[i][0], min);
            max = Math.max(matrix[i][matrix.length - 1], max);
        }
    }

    int numberOfSmallest(int[] matrix, int target) {

        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

}