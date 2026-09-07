class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        return binarySearch(bloomDay, m, k);
    }

    int binarySearch(int[] bloomDay, int m, int k) {
        int low = 0;
        int high = 0;
        int ans = -1;

        for (int i = 0; i < bloomDay.length; i++) {
            high = Math.max(high, bloomDay[i]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isvalid(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    boolean isvalid(int[] bloomDay, int day, int m, int k) {
        int ans = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            int count = 0;

            while (i < bloomDay.length && bloomDay[i] <= day) {
                count++;
                i++;
            }

            ans += count / k;
        }

        return ans >= m;
    }
}