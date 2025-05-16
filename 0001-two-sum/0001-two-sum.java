class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

       
        for (int i = 0; i < n; i++) {
            int firstValue=nums[i];
            int secondValue=target-nums[i];
            if(map.containsKey(secondValue)){
                int index2=map.get(secondValue);
                return new int[]{index2,i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
