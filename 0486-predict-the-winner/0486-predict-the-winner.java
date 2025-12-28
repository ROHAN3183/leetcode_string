class Solution {
    public boolean predictTheWinner(int[] nums) {
        return dfs(nums, 0, nums.length - 1, 0, 0, true);
    }

    boolean dfs(int[] nums, int i, int j, int s1, int s2, boolean term) {
        if (i > j) {
            if (s1 >= s2) {
                return true;
            }
            return false;
        }
        boolean player1 = false;
        boolean player2 = false;
        if (term) {
            player1 = dfs(nums, i + 1, j, s1 + nums[i], s2, false) || dfs(nums, i, j - 1, s1 + nums[j], s2, false);

        } else {
            player2 = dfs(nums, i + 1, j, s1, s2 + nums[i], true) && dfs(nums, i, j - 1, s1, s2 + nums[j], true);
        }
        return player1 || player2;

    }
}