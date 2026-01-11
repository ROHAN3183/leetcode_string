class Solution {
    int totalSum = 0;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        for (int sum : nums) {
            totalSum += sum;
        }

        if (totalSum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        reverse(nums);

        if (dfs(nums, used, 0, 0, totalSum / k, k)) {
            return true;
        }
        return false;
    }

    boolean dfs(int[] nums, boolean[] used, int idx, int currSum, int target, int k) {
        if (k == 0) {
            return true;
        }
        if (currSum == target) {
            return dfs(nums, used, 0, 0, target, k - 1);
        }

        for (int i = idx; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (currSum + nums[i] > target) {
                continue;
            }

            used[i] = true;
            if (dfs(nums, used, i + 1, currSum + nums[i], target, k)) {
                return true;
            }
            used[i] = false;
        }

        return false;
    }

    void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return;
    }
}