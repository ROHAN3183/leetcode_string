class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int size = nums.length;
        List<Long> list = new ArrayList<>();
        int mod = 1_000_000_007;
        for (int i = 0; i < size; i++) {
            long sum = 0;
            for (int j = i; j < size; j++) {
                sum = (sum + nums[j]) % mod;
                list.add(sum);
            }
        }
        Collections.sort(list);
        long sum = 0;

        for (int i = left - 1; i < right; i++) {
            sum = (sum + list.get(i)) % mod;
        }
        return (int) sum;

    }
}