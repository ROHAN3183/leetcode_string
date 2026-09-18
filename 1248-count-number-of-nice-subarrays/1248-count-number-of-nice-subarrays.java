class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    int atMost(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int count = 0;
        int oddCount = 0;
        while (j < nums.length) {
            if (nums[j] % 2 != 0) {
                oddCount++;
            }
            while (oddCount > k) {
                if (nums[i] % 2 != 0) {
                    oddCount--;
                }
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}