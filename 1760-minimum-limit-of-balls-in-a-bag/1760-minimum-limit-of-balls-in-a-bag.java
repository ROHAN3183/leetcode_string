class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        int ans=-1;
        while (low <= high) {
            int mid = low+(high-low)/2;
            if(isValid(nums, maxOperations,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    boolean isValid(int[] nums, int maxOperations, int mid) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {
                count += (nums[i] - 1) / mid;
            }
        }
        return maxOperations >= count;
    }
}