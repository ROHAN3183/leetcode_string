class Solution {
    Integer [][] dp;
    public int numSquares(int n) {
        ArrayList<Integer> nums = function(n);
        dp = new Integer[nums.size()][n+1];
        return dfs(nums, 0, n);
    }

    int dfs(ArrayList<Integer> nums, int idx, int target) {
        if (target == 0) {
            return 0;
        }
        if (target < 0 || idx >= nums.size()) {
            return Integer.MAX_VALUE;
        }
        if(dp[idx][target]!=null){
            return dp[idx][target];
        }
        int min = Integer.MAX_VALUE;
        for (int i = idx; i < nums.size(); i++) {
            if (nums.get(i)<=target) {
                int ans = dfs(nums, i, target - nums.get(i));
                if (ans != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + ans);
                }
            }

        }
        return dp[idx][target]=min;
    }

    ArrayList<Integer> function(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            list.add(i * i);
            i++;
        }
        return list;
    }

}