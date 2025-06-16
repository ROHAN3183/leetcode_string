class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int evenSum = 0;
        int[] result = new int[n];

        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] % 2 == 0) {
                evenSum += nums[i];
            }
        }

        for (int i = 0; i < n&&i<nums.length; i++) {
            int idx = queries[i][1];
            int val = queries[i][0];
            if(nums[idx]%2==0){
                evenSum-=nums[idx];
            }
            nums[idx]+=val;
            if(nums[idx]%2==0){
                evenSum+=nums[idx];
            }

            result[i]=evenSum;
        }

        return result;
    }
}
