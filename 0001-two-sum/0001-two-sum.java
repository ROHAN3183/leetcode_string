#BRUTE 
    class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // Check every pair
                if (nums[i] + nums[j] == target) { // If pair sum equals target
                    return new int[] {i, j}; // Return the indices
                }
            }
        }
        return new int[0]; // Return empty array if no solution
    }
}

#OPTIMIZED
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
