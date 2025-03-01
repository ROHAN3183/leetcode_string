logic of the code:
use Kadane’s algorithm check wheather comming number is greater then the sum of the previous then make it as then the max_sum 
find both the max_sum of the subarray also find the min_sum of the subarray because we have to find the absolute differnce of the
subarray.  
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n=nums.length;
        int current=nums[0];
        int max_sum=nums[0];
        for(int i=1;i<n;i++){
            current=Math.max(nums[i],current+nums[i]);
            max_sum=Math.max(current,max_sum);
        }
        current=nums[0];
       int  min_sum=nums[0];
        for(int i=1;i<n;i++){
            current=Math.min(nums[i],current+nums[i]);
            min_sum=Math.min(current,min_sum);
        }
        int result=Math.max(Math.abs(max_sum),Math.abs(min_sum));
        return result;
    }
}
