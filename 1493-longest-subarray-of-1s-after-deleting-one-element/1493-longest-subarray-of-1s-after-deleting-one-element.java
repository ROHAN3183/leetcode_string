class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=0;
        int count=0;
        int maxSize=0;
        while(j<n){
            if(nums[j]!=1){
                count++;
            }
            while(count>1){
                if(nums[i]==0){
                    count--;
                }
                i++;
            }
            maxSize=Math.max(maxSize,j-i);
            j++;
        }
        return maxSize;
    }
}