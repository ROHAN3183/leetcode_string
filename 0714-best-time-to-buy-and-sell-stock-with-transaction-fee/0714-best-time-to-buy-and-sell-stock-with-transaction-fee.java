class Solution {
    Integer [][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new Integer [prices.length][2];
        return dfs(prices,fee,0,-1);
    }
    int dfs(int [] prices , int fee , int idx , int buy){
        if(idx>=prices.length){
            return 0;
        }
        int buyState = (buy==-1?0:1);
        if(dp[idx][buyState]!=null){
            return dp[idx][buyState];
        }
        int ans;

        if(buy==-1){
            int take  = -prices[idx]+dfs(prices, fee , idx+1, prices[idx]);
            int nottake = dfs(prices,fee , idx+1,buy);
            ans=Math.max(take,nottake);
        }
        else{
            int sell = (prices[idx] - fee )+ dfs(prices,fee,idx+1,-1);
            int notsell = dfs(prices,fee , idx+1,buy);
            ans= Math.max(sell,notsell);
        }
        return dp[idx][buyState]=ans;
    }
}