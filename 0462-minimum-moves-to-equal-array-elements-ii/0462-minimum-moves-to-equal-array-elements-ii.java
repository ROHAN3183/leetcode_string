class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        if (nums.length == 1) {
            return ans;
        }
        Arrays.sort(nums);
        int median = nums[n / 2];
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - median);
        }
        return ans;
    }
}