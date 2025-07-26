class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeSet<Integer> set = new TreeSet<>();
        int n = nums.length;
        int i = 0;
        int j = 0;
        int size = 0;
        while (j < n) {
            set.add(nums[j]);
            while ((set.last() - set.first()) > limit) {
                set.remove(nums[i]);
                i++;
            }
            size = Math.max(size, j - i + 1);
            j++;
        }
        return size;
    }
}