class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        if(sum(nums)==n){
            return 0;
        }

        int i=0;
        int j=0;
        int count=0;
        while(i<=n-3){
            if(nums[i]==0){
                j=i;
                while(j<n &&j<i+3){
                    if(nums[j]==0){
                        nums[j]=1;
                    }
                    else{
                        nums[j]=0;
                    }
                    j++;
                }
                count++;
            }
            i++;
        }
        int sum=0;
        if(sum(nums)==n){
            return count;
        }
        
        return -1;

    }
    int sum(int []nums){
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
        }
        return sum;

    }
}