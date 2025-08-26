class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] prefix = new long[n];

        long sum = 0;
        long max=-1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
        for (int i = n - 1; i >= 2; i--) {
            int c = nums[i];
            if (prefix[i - 1] > c) {
                max = Math.max(max, prefix[i - 1] + c);
            }
        }
        return max;

    }
}