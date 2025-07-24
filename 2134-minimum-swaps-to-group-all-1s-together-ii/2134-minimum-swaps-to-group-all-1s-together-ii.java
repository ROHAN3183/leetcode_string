class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] extra = new int[2 * n];
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                ones++;
            }
        }
        for (int i = 0; i < 2 * n; i++) {
            extra[i] = nums[i % n];
        }
        int i = 0;
        int j = 0;
        int zeroCount = 0;
        int minSwap = Integer.MAX_VALUE;

        while (j - i + 1 <= ones) {
            if (extra[j] == 0) {
                zeroCount++;
            }
            j++;
        }
        minSwap = zeroCount;

        while (j < 2 * n) {
            if (extra[i] == 0) {
                zeroCount--;
            }
            if (extra[j] == 0) {
                zeroCount++;
            }
            minSwap = Math.min(minSwap, zeroCount);
            i++;
            j++;
        }
        return minSwap;

    }
}