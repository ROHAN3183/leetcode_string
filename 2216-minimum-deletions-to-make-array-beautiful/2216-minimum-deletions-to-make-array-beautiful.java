class Solution {
    public int minDeletion(int[] nums) {
        int n=nums.length;
        int i=0;
        int count=0;
        for(int j=0;j<n-1;j++){
            if(i%2==0 && nums[j]==nums[j+1]){
                count++;

            }
            else{
                i++;
            }
        }
        if((n-count)%2!=0)count++;
        return count;
    }
}