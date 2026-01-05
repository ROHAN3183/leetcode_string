class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int max = maximumSubarraySum(nums);
        int min = minimumSubarraySum(nums);

        return Math.max(Math.abs(max), Math.abs(min));

    }

    int maximumSubarraySum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            max = Math.max(max, currSum);
        }
        return max;
    }

    int minimumSubarraySum(int[] nums) {
        int min = Integer.MAX_VALUE;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum = Math.min(currSum + nums[i], nums[i]);
            min = Math.min(min, currSum);
        }
        return min;
    }
}