/*LOGIC OF THE CODE -> there are only 2 possibility their we can start from the 0 index or 1 index so we have to write  the 
two funcion.
add the current cost + dfs(cost,idx+1 ) dfs(cost ,idx+2) min of the each
*/
**********************************************MEMORIZATION**********************************************************************
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[1001];
        Arrays.fill(dp, -1);
        return Math.min(dfs(cost, 0, dp), dfs(cost, 1, dp));
    }

    int dfs(int[] cost, int idx, int[] dp) {
        if (idx >= cost.length) {
            return 0;

        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int oneStep = cost[idx] + dfs(cost, idx + 1, dp);

        int twoSteps = cost[idx] + dfs(cost, idx + 2, dp);

        return dp[idx] = Math.min(oneStep, twoSteps);

    }
}
*********************************************SPACE OPTIMIZED CODE*****************************************************************
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev1 = 0;
        int prev2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {

            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;

        }
        return Math.min(prev1, prev2);
    }
}
