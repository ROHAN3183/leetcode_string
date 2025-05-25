class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i - 1]);
            }
        }

        if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) return 0;

        int leftIndex = -1;
        int rightIndex = -1;

        // First occurrence of max
        for (int i = 0; i < n; i++) {
            if (arr[i] == max) {
                leftIndex = i;
                break;
            }
        }

        // Last occurrence of min
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == min) {
                rightIndex = i;
                break;
            }
        }

        // ✅ Fix: handle when leftIndex or rightIndex are invalid or out of order
        if (leftIndex == -1 || rightIndex == -1 || rightIndex < leftIndex) {
            return Math.min(n - leftIndex - 1, rightIndex);  // remove left or right
        }

        // If full array range, trim from one side
        if (rightIndex - leftIndex + 1 >= n) {
            return Math.min(rightIndex, n - 1 - leftIndex);
        }

        return rightIndex - leftIndex + 1;
    }
}
