class Solution {
    public int rob(int[] nums) {
        return dfs(nums,0);
    }
    int dfs(int [] nums , int idx){
        if(idx>=nums.length){
            return 0;
        }
        int first = nums[idx] + dfs(nums ,idx+2);
        int second = 0 + dfs(nums , idx+1);
        return Math.max(first ,second);
    }
}