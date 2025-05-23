class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int last_jump=0;
        int max_jump=0;
        int count=0;
        if(n==1){
            return 0;
        }
        for(int i=0;i<n;i++){
            max_jump=Math.max(max_jump,nums[i]+i);
            if(i==last_jump){
                last_jump=max_jump;
                count++;
            }
            if(last_jump>=n-1){
                return count;
            }
        }
        return count;
    }
}