class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        return Math.max(robLinear(nums, n - 2, 0), robLinear(nums, n - 1, 1));
    }

    int robLinear(int[] nums, int start, int end) {

        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i >= end; i--) {

            int take = nums[i] + prev2;
            int skip = 0 + prev1;

            int curr = Math.max(take, skip);
            prev2 = prev1;
            prev1 = curr;

        }

        return prev1;
    }
}