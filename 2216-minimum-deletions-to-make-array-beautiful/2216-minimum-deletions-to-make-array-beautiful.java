class Solution {
    public int minDeletion(int[] nums) {
        int deletions = 0;
        int n = nums.length;
        int pos = 0; // current position in the new array
        for (int i = 0; i < n; i++) {
            if (pos % 2 == 0) {
                if (i + 1 < n && nums[i] == nums[i + 1]) {
                    deletions++;
                } else {
                    pos++;
                }
            } else {
                pos++;
            }
        }
        if (pos % 2 != 0) {
            deletions++;
        }
        return deletions;
    }
}