class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int count = 0;
        Arrays.sort(nums);
        while (j < n && i < n) {
            if(nums[j]-nums[i]>k){
                count++;
                i=j;
            }
            j++;
        }
        return count + 1;
    }
}