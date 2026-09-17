class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int zero = 0;
        int one = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                zero++;
            } else {
                one++;
            }
            while (j - i + 1 - one > k) {
                if (nums[i] == 0) {
                    zero--;
                } else {
                    one--;
                }
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}