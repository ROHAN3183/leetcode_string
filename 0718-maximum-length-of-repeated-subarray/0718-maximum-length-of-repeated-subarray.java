class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int maxLen = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                maxLen = Math.max(maxLen, count(nums1, nums2, i, j));
            }
        }
        return maxLen;
    }
    // Helper: counts common contiguous subarray starting at (i, j)
    private int count(int[] nums1, int[] nums2, int i, int j) {
        if (i >= nums1.length || j >= nums2.length) return 0;
        if (nums1[i] == nums2[j]) {
            return 1 + count(nums1, nums2, i + 1, j + 1);
        }
        return 0;
    }
}
