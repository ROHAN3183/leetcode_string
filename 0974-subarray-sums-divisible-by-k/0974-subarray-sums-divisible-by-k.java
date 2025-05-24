class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);//initial remainder as the 0 with the frequency 1.
        int prefixSum=0;
        int result=0;


        for(int i=0;i<n;i++){
            prefixSum=prefixSum+nums[i];
            if(prefixSum<0){
                prefixSum=prefixSum+k;
            }
            int remainder=prefixSum%k;
            if(map.containsKey(remainder)){
                result=result+map.get(remainder);
            }
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }

        return result;
        
    }
}