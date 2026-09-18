class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    int atMost(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() > k) {
                int val = map.get(nums[i]);
                if (val == 1) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], val - 1);
                }
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}