class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int result=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int option1=subarray(nums,0,i,firstLen)+subarray(nums,i+1,nums.length-1,secondLen);
            int option2=subarray(nums,0,i,secondLen)+subarray(nums,i+1,nums.length-1,firstLen);
            int max=Math.max(option1,option2);
            
            result=Math.max(result,max);
        }
        return result;
        
    }

    int subarray(int[] nums, int start, int end, int target) {
        if (end - start + 1 < target) {
            return Integer.MIN_VALUE;
        }
        int i = start;
        int j = start;

        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (j <= end) {
            sum += nums[j];

            if (j - i + 1 == target) {
                max = Math.max(max, sum);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return max;
    }
}