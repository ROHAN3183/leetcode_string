class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i-1]==nums[i]){
                nums[i-1]=nums[i-1]*2;
                nums[i]=0;
            }
        }
        int j=0;
        int i=0;
        while(j<n){
            if(nums[j]!=0){
                nums[i]=nums[j];
                i++;
            }
            j++;
        }
        while(i<n){
            nums[i]=0;
            i++;
        }
        return nums;
    }
}