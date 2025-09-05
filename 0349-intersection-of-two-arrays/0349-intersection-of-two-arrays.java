class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            while (i < nums1.length - 1 && nums1[i] == nums1[i + 1]) {
                i++;
            }
            if (binarySearch(nums2, nums1[i])) {
                list.add(nums1[i]);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    boolean binarySearch(int[] nums2, int target) {
        int low = 0;
        int high = nums2.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums2[mid] == target) {
                return true;
            } else if (nums2[mid] < target) {
                low = mid + 1;
            } else if (nums2[mid] > target) {
                high = mid - 1;
            }

        }
        return false;
    }
}