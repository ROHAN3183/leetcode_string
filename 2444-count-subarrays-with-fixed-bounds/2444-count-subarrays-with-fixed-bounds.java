# BRUTE FORCE
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n=nums.length;
        long result=0;
        for(int i=0;i<n;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=i;j<n;j++){
                list.add(nums[j]);
                int max_list=Collections.max(list);
                int min_list=Collections.min(list);
                if(max_list==maxK && min_list==minK){
                    result++;
                }
                if(max_list>maxK && min_list<minK){
                    break;
                }
            }
        }
        return result;
    }
}
#OPTIMIZED CODE
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
           int count=Math.min(min_index,max_index)-out_ofBound;
           if(count>0){
            result=result+count;
           }
        }
        return result;
    }
}
