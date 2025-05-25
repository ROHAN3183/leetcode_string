class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int []copy=Arrays.copyOf(nums,nums.length);
        Arrays.sort(copy);//ascending order
        int i=0;
        int j=0;
        while(j<n){
            if(nums[i]==copy[j]){
                i++;
            }
            j++;
        }

        return j-i;
        
    }
}