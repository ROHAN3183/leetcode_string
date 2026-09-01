class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int max = 0;
        int count=0;
        while (j < n) {
            if (nums[j] == 0) {
                count++;
            }

            while (i<=j && count > k) {
                if (nums[i] == 0) {
                    count--;
                }
                i++;
            }
            if (count<=k) {
                max = Math.max(max, j - i + 1);
            }
            j++;

        }
        return max;
    }
}