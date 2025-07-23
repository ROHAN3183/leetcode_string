class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int currSum = 0;
        int max = 0;
        Arrays.sort(nums);
        while (j < n) {

            currSum += nums[j];

            while ((long)nums[j] * (j - i + 1) - currSum > k) {
                currSum -= nums[i];
                i++;
            }
            max = Math.max(max, j - i + 1);

            j++;

        }
        return max;
    }
}