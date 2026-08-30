class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int i = 0;
        while (i < nums.length) {
            int count = 1;
            while ((i + 1 < nums.length) && ((nums[i + 1] - nums[i] == 1) || (nums[i + 1] == nums[i]))) {
                if (nums[i + 1] == nums[i]) {
                    i++;
                    continue;
                } else if (nums[i + 1] - nums[i] == 1) {
                    count++;
                }
                i++;
            }
            max = Math.max(max, count);
            i++;
        }
        return max;
    }
}