class Solution {
    int totalSum;

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        int maxSum = maximumSubarraySum(nums);
        int minSum = minimumSubarraySum(nums);

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
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