class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        long prefixSum=0;
        // prefixSum
        for(int i=0;i<n;i++){
            prefixSum=prefixSum+nums[i];

        }
        int remainder=(int)(prefixSum%p); //number to delete
        if(remainder==0)return 0;
   
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int result=n;
        int sum=0;

        for(int i=0;i<n;i++){
            sum=(sum+nums[i]) % p;
            int target=(sum-remainder+p)%p;

            if(map.containsKey(target)){
                int idx=map.get(target);
                result=Math.min(i-idx,result);
            }
            
            map.put(sum,i);
        }
        if(result==n)return -1;
        return result;
        
    }
}