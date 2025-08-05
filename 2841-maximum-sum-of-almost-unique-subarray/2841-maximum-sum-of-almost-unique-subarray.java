class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.size();
        int i = 0;
        int j = 0;
        long sum = 0;
        long max = 0;
        while (j < n) {

            sum += nums.get(j);
            map.put(nums.get(j), map.getOrDefault(nums.get(j), 0) + 1);

            while (i < j && j - i + 1 > k) {
                int freq = map.get(nums.get(i));
                if (freq == 1) {
                    map.remove(nums.get(i));
                } else {
                    map.put(nums.get(i), freq - 1);
                }
                sum -= nums.get(i);
                i++;

            }
            if (map.size() >= m && j - i + 1 == k) {
                max = Math.max(max, sum);
            }
            j++;
        }
        return max;

    }
}