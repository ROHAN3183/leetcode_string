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