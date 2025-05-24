class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int prefixSum=0;
        int result=0;
        map.put(0,1);

        for(int i=0;i<n;i++){
            prefixSum=prefixSum+nums[i];

            int checker=prefixSum-k;
            if(map.containsKey(checker)){
                result=result+map.get(checker);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return result;
    }
}