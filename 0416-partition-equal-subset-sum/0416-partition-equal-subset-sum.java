class Solution {
    int totalSum=0;
    Boolean [][]memo;
    public boolean canPartition(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        int target = totalSum / 2;
        memo=new Boolean[nums.length][target+1];
        return dfs(nums, 0, 0, target);
    }

    boolean dfs(int[] nums, int idx, int sum, int target) {
        if (sum == target) {
            return true;
        }
        if (idx >= nums.length || sum > target) {
            return false;
        }
        if(memo[idx][target]!= null){
            return memo[idx][target];
        }
        memo[idx][target]=dfs(nums, idx + 1, sum + nums[idx], target) || dfs(nums, idx + 1, sum, target);
        return memo[idx][target];
    }
}