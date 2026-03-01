class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        boolean pivot = false;
        while (i > 0) {
            if (i - 1 >= 0 && nums[i - 1] < nums[i]) {
                pivot = true;
                break;
            }
            i--;
        }
        if (!pivot) {
            Arrays.sort(nums);
            return;
        }
        int temp = nums[i - 1];
        nums[i - 1] = nums[nums.length - 1];
        nums[nums.length - 1] = temp;
        reverse(nums, i, nums.length - 1);
        return;
    }

    void reverse(int[] nums, int i, int j) {
        while (i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return;
    }
}