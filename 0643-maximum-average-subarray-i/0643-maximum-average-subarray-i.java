class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = 0;
        double sum = 0;
        double max = Double.NEGATIVE_INFINITY;
        while (j < nums.length) {
            sum += nums[j];
            while (j - i + 1 > k) {
                sum -= (double)nums[i];
                i++;
            }
            if (j - i + 1 == k) {
                max = Math.max(sum / k, max);
            }
            j++;
        }
        return max;
    }
}