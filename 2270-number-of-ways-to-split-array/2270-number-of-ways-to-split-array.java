
#optimized!
1. Compute the prefix sum array (`prefix_sum`) where each element stores the cumulative sum of the array up to that index.  
2. Iterate through the array up to the second-last index (`j <= n - 2`).  
3. For each split point `j`, check if the sum of the left subarray (`prefix_sum[j]`) is greater than or equal to the sum of the right subarray (`total sum - prefix_sum[j]`).  
4. Increment the `count` if the condition is satisfied.  
5. Return the `count` as the total number of valid split points. 
    
class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        int j=0;
        int count=0;
        long []prefix_sum=new long[n];
        long sum=0;

        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            prefix_sum[i]=sum;
        }

        while(j<=n-2){
            if(prefix_sum[j]>=prefix_sum[n-1]-prefix_sum[j]){
                count++;
            }
            j++;
        }
        return count;
    }
}

#brute 
class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n-1;i++){
            long left_sum=0;
            long right_sum=0;
            for(int j=0;j<=i;j++){
                left_sum=left_sum+nums[j];
            }
            for(int k=i+1;k<n;k++){
                right_sum=right_sum+nums[k];
            }
            if(left_sum >=right_sum){
                count++;
            }
        }
        return count;
    }
}
    
