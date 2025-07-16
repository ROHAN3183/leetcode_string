/*LOGIC OF THE CODE :
Similar to the fibonaccai series 
*/
*********************************************MEMORIZATION***********************************************************************
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return DP(n, dp);

    }

    int DP(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = DP(n - 1, dp) + DP(n - 2, dp);
        
        return dp[n];
    }
}
************************************************TABULATION METHOD****************************************************************
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return DP(n, dp);

    }

    int DP(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }
}
****************************************************SPACE OPTIMIZATION**********************************************************
class Solution {
    public int climbStairs(int n) {
        return DP(n);
    }

    int DP(int n) {

        if (n <= 1) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 1;
        int curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
}
