class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
            if (nums[i] == 0) {
                prefix = 1;
            }
            if (nums[n - i - 1] == 0) {
                suffix = 1;
            }
        }
        return max;
    }
}