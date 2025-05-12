class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        int [] result=new int [n];
        Arrays.fill(result,-1);
        int i=0;
        int j=0;
        int windowSize=2*k+1;
        if(windowSize>n){
            return result;
        }
        long sum=0;
        while(j<n){
            sum=sum+nums[j];
            if(j-i+1==windowSize){
                result[i+k]=(int )sum/windowSize;
                sum=sum-nums[i];
                i++;
            }
            j++;
        }
        return result;
    }
}