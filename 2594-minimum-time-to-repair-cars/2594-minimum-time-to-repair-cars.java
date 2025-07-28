class Solution {
    public long repairCars(int[] ranks, int cars) {
        int minRank = Integer.MAX_VALUE;
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
        }

        long low = 1;
        long high = (long) minRank * cars * cars;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isValid(ranks, mid, cars)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    boolean isValid(int[] ranks, long time, int cars) {
        long count = 0;
        for (int r : ranks) {
            count += (long) Math.sqrt((double) time / r);
            if (count >= cars) return true;
        }
        return false;
    }
}
