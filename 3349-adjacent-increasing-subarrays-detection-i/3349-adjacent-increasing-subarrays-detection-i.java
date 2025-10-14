class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int i = 0;
        int j = 0;
        int n = nums.size();
        while (i <= n-2*k) {

            while (j < n && j - i + 1 < 2 * k) {
                j++;
            }

            if (j - i + 1 == 2 * k) {
                if (isValid(nums, i, i + k) && isValid(nums, i + k,i+2*k)) {
                    return true;
                }
            }

            i++;
        }
        return false;
    }

    boolean isValid(List<Integer> nums, int low, int high) {
        for (int i = low; i < high-1; i++) {
            if (i+1<nums.size() &&nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}