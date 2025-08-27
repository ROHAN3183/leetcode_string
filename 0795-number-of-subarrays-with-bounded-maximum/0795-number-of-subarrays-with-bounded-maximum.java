class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int i = 0, j = 0;
        long result = 0;

        while (j < n) {
            if (nums[j] > right) {
                long invalid = solver(nums, i, j, left, right);
                long len = j - i;
                long valid = len * (len + 1) / 2;
                result += valid - invalid;
                j++;
                i = j;
            } else if (j == n - 1) {
                long invalid = solver(nums, i, n, left, right);
                long len = n - i;
                long valid = len * (len + 1) / 2;
                result += valid - invalid;
                break;
            } else {
                j++;
            }
        }
        return (int) result;
    }

    long solver(int[] nums, int i, int j, int left, int right) {
        long ans = 0;
        while (i < j) {
            if (nums[i] < left) {
                long count = 0;
                while (i < j && nums[i] < left) {
                    count++;
                    i++;
                }
                ans += count * (count + 1) / 2;
            } else {
                i++;
            }
        }
        return ans;
    }
}
