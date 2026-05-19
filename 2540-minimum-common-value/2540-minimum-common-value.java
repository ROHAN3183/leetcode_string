class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int k = 0; k < nums1.length; k++) {
            if (isvalidBS(nums1[k], nums2)) {
                return nums1[k];
            }
        }
        return -1;
    }

    boolean isvalidBS(int target, int[] nums2) {
        int low = 0;
        int high = nums2.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums2[mid] == target) {
                return true;
            } else if (nums2[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}