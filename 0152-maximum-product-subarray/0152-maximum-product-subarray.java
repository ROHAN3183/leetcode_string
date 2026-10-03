class Solution {
    public int maxProduct(int[] nums) {
        int pre=1;
        int suf=1;
        int n=nums.length;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(pre==0){
                pre=1;
            }
            if(suf==0){
                suf=1;
            }
            pre=pre*nums[i];
            suf*=nums[n-i-1];
            ans=Math.max(ans,Math.max(pre,suf));
        }
        return ans;
    }
}