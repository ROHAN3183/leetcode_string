class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        int[] store = new int [1000];

        for (int i = 0; i < nums1.length; i++) {
            store[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (store[nums2[i]] > 0) {
                list.add(nums2[i]);
                store[nums2[i]]--;
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

}