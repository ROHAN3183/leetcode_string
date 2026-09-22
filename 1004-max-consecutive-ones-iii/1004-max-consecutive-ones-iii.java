class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int one =0;
        int max=0;
        while(j<nums.length){
            if(nums[j]==1){
                one++;
            }
            while(j-i+1-one>k){
                if(nums[i]==1){
                    one--;
                }
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}