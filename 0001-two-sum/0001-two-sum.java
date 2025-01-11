class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int first=nums[i];
            if(map.containsKey(target-first)){
                return new int[]{ map.get(target-first),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0};
    }
}