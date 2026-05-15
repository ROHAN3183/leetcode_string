class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefix = 0;
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            if (map.containsKey(prefix - target)) {
                if (left == Integer.MIN_VALUE && right == Integer.MAX_VALUE) {
                    left = map.get(prefix - target) + 1;
                    right = i;
                    count++;
                } else {
                    int newleft = map.get(prefix - target) + 1;
                    int newright = i;
                    if (newleft > right) {
                        left = map.get(prefix - target) + 1;
                        right = i;
                        count++;
                    }
                }
            }
            map.put(prefix, i);
        }
        return count;
    }
}