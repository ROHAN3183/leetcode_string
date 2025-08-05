class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int pos = 0;
        while (j < n) {
            int count = 0;
            while (j < n && nums[i] == nums[j]) {
                count++;
                j++;
            }
            if (count >= 2) {
                nums[pos++] = nums[i];
                nums[pos++] = nums[i];
            } else if (count < 2) {
                nums[pos++] = nums[i];
            }
            i = j;
        }
        return pos;
    }
}