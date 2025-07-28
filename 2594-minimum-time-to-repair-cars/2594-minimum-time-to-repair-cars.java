class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = (long) minRank * (long) cars * (long) cars;
        long ans = Long.MAX_VALUE;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isValid(ranks, mid, (long) cars)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    boolean isValid(int[] ranks, long time, long cars) {
        long count = 0;
        for (int i = 0; i < ranks.length; i++) {
            count += (long) Math.sqrt((double) time / ranks[i]);
            if (count >= cars)
                return true;
        }
        return false;
    }
}
