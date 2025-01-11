class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int [] result=new int[2];
        int n=nums.length;
        int idx=0;
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<n;i++){
            int first=nums[i];
            if(map.containsKey(target-first)&& map.get(target - first) != i){
                result[idx++]=i;
                result[idx++]=map.get(target-first);
                break;
            }
        }
        return result;
    }
}