class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        int sum=0;
        int max_length=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                sum=sum+nums[i];
            }
            else{
                sum=sum-1;
            }

            if(map.containsKey(sum)){
                int end=i;
                int start=map.get(sum);
                max_length=Math.max(end-start,max_length);
            }
            else{
                map.put(sum,i);
            }
        }
        return max_length;
    }
}