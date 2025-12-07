class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        if (nums.length < 3)
            return result;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            result +=solve(nums, key);
        }
        return result;
    }

    int solve(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        for (int j = 0; j < n - 2; j++) {
            int count = 1;
            int ans = 0;
            for (int i = j + 1; i < n; i++) {
                if (nums[i] - nums[i - 1] == k) {
                    count++;

                } else {
                    break;
                }
                if (count >= 3) {
                    ans++;
                }
            }
            result += ans;
        }
        return result;
    }
}