class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        int low = 1;
        int high = max;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(candies, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;

    }

    boolean isValid(int[] candies, int mid, long k) {
        long count = 0;
        for (int i = 0; i < candies.length; i++) {
            count += candies[i] / mid;
        }
        if (count >= k) {
            return true;
        }
        return false;
    }
}