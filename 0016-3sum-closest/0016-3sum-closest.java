class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        int closest_sum = Integer.MAX_VALUE/2;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int current_sum=nums[i]+nums[j]+nums[k];
                        if(Math.abs(current_sum-target)<Math.abs(closest_sum-target)){
                            closest_sum=current_sum;
                        }
                }
            }
        }
        return closest_sum;
    }
}