class Solution {
    public long repairCars(int[] ranks, int cars) {
        int maxRank = 0;
        for (int rank : ranks) {
            maxRank = Math.max(maxRank, rank);  // find the maximum rank
        }

        long low = 1;
        long high = (long) maxRank * cars * cars;  // use maxRank instead of minRank
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
        for (int i = 0; i < ranks.length; i++) {
            count += (long) Math.sqrt((double) time / ranks[i]);
            if (count >= cars) return true;
        }
        return false;
    }
}
