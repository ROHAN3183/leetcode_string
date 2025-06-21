class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long[] prefix = new long[n];
        int min = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }

        int i = 0;
        while (i < n - 1) {
            long start = prefix[i] / (i + 1);
            long end = (prefix[n - 1] - prefix[i]) / (n - i - 1);
            int value = (int)Math.abs(start - end);

            if (min > value) {
                idx = i;
                min = value;
            }
            i++;
        }

        if (i == n - 1) {
            int value = (int)(prefix[n - 1] / (i + 1));
            if (min > value) {
                idx = i;
                min = value;
            }
        }

        return idx;
    }
}
