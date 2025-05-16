class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int k=0;
        int temp[]=new int[2];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    temp[k]=i;
                    temp[k+1]=j;
                    k++;
                    break;

                }
            }
        }
        return temp;
    }
}