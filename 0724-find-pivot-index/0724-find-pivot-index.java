class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sumLeft = 0;
        int sumRight = 0;
        int[] prefixLeft = new int[n];
        int[] prefixRight = new int[n];

        for (int i = 0; i < n; i++) {
            sumLeft = sumLeft + nums[i];
            prefixLeft[i] = sumLeft;
        }

        for (int i = n - 1; i >= 0; i--) {
            sumRight = sumRight + nums[i];
            prefixRight[i] = sumRight;
        }
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (prefixLeft[i] == prefixRight[j]) {
                return i;

            }
            i++;
            j++;
        }
        return -1;

    }
}