class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
      HashMap<Integer,Integer>map=new HashMap<>();
      int n=nums.length;
      int sum=0;
      int start=0;
      int end=0;
      map.put(sum,-1);
      for(int i=0;i<n;i++){
            sum=sum+nums[i];
            int remainder=sum%k;
            if(map.containsKey(remainder)){
                end=i;
                start=map.get(remainder);
                if(end-start>=2){
                    return true;
                }
            }
            else{
                if(map.containsKey(remainder)){
                    map.put(remainder,i);
                }
            }
        }
        return false;
      }  
}
