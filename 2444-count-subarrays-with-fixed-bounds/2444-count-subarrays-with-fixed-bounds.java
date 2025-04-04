class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n=nums.length;
        int min_index=-1;
        int max_index=-1;
        int out_ofBound=-1;
        long result=0;
        for(int i=0;i<n;i++){
            if(nums[i]>maxK || nums[i]<minK){
                out_ofBound=i;
            }
            if(nums[i]==minK){
                min_index=i;
            }
            if(nums[i]==maxK){
                max_index=i;
            }
            if(min_index!=-1 && max_index!=-1){
                result=result+Math.max(0,Math.min(min_index,max_index)-out_ofBound);
            }
        }
        return result;
    }
}