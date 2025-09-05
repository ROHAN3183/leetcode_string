class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Arrays.sort(nums2);
        for (int i = 0; i < nums2.length; i++) {
            while (i < nums2.length-1 && nums2[i] == nums2[i + 1]) {
                i++;
            }
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}