/*LOGIC OF THE CODE
if taking nums[i] then call the dfs(i+2) because cannot take the adjacent house 
if not taking then call the dfs(i+1) because current house not taken.
*/
********************************************MEMORIZATION*************************************************************************
class Solution{
    public int rob(int[] nums) {
        int[] dp = new int[101];
        Arrays.fill(dp, -1);
        return dfs(nums, 0, dp);
    }

    int dfs(int[] nums, int idx, int[] dp) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int first = nums[idx] + dfs(nums, idx + 2, dp);
        int second = 0 + dfs(nums, idx + 1, dp);

        return dp[idx] = Math.max(first, second);
    }
}
****************************************SPACE OPTIMIZATION************************************************************************
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int prev1 = 0;
        int prev2 = 0;

        for (int i = n - 1; i >= 0; i--) {

            int notSkip = nums[i] + prev2;
            int toSkip = prev1;

            int curr = Math.max(notSkip, toSkip);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
