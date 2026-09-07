class Solution {
    public int singleNonDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Check if mid is the single element
            if ((mid == 0 || nums[mid - 1] != nums[mid]) &&
                (mid == nums.length - 1 || nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }

            // mid is even
            if (mid % 2 == 0) {

                if (mid > 0 && nums[mid - 1] == nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } 
            // mid is odd
            else {

                if (nums[mid - 1] == nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}