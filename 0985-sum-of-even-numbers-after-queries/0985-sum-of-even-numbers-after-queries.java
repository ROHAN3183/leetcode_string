class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        int n1 = nums.length;
        int n2 = queries.length;
        for (int i = 0; i < n1 && i < n2; i++) {
            int idx = queries[i][1];
            int val = queries[i][0];
            nums[idx] = nums[idx] + val;
            calculateSum(nums, result);

        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }
        return ans;

    }

    void calculateSum(int[] nums, List<Integer> result) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                sum += nums[i];
            }
        }
        result.add(sum);

    }
}