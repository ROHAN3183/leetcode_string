class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums); 
        int start = 0;     
        long total = 0;    
        int maxFrequency = 0;
        int end = 0;
        while (end < nums.length) {
            total += nums[end]; 
            while ((long) nums[end] * (end - start + 1) - total > k) {
                total -= nums[start]; 
                start++;             
            }
            maxFrequency = Math.max(maxFrequency, end - start + 1);

            end++; 
        }
        return maxFrequency; 
    }
}
