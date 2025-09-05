class Solution {
    int firstPosition = Integer.MAX_VALUE;
    int lastPosition = Integer.MIN_VALUE;

    public int removeElement(int[] nums, int val) {
        int result;
        Arrays.sort(nums);
        if (binarySearchFirstPosition(nums, val) == Integer.MAX_VALUE
                || binarySearchLastPosition(nums, val) == Integer.MIN_VALUE) {
            return nums.length;
        }
        int n = lastPosition - firstPosition + 1;
        result = nums.length - n;
        int j = lastPosition + 1;
        for (int i = firstPosition; j < nums.length; i++, j++) {
            nums[i] = nums[j];
        }

        return result;

    }

    int binarySearchFirstPosition(int[] nums, int val) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == val) {
                firstPosition = Math.min(firstPosition, mid);
                high = mid - 1;
            } else if (nums[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return firstPosition;
    }

    int binarySearchLastPosition(int[] nums, int val) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == val) {
                lastPosition = Math.max(lastPosition, mid);
                low = mid + 1;
            } else if (nums[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lastPosition;
    }
}