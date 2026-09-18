class Solution{
    public long maximumSubarraySum(int[] nums,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        long sum=0;
        long maxSum=0;

        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            sum+=nums[j];

            while(j-i+1>k){
                sum-=nums[i];
                int val=map.get(nums[i]);

                if(val==1){
                    map.remove(nums[i]);
                }else{
                    map.put(nums[i],val-1);
                }

                i++;
            }

            if(map.size()==k){
                maxSum=Math.max(maxSum,sum);
            }

            j++;
        }

        return maxSum;
    }
}