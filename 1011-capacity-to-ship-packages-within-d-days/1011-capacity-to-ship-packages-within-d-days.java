class Solution {

    public int shipWithinDays(int[] weights, int days) {
        return binarySearch(weights, days);
    }

    int binarySearch(int[] weights, int days) {

        int low = 0;
        int high = 0;
        int ans = 0;

        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isvalid(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    boolean isvalid(int[] weights, int days, int w) {

        int sum = 0;
        int d = 1;

        for (int i = 0; i < weights.length; i++) {

            if (weights[i] > w) {
                return false;
            }

            if (sum + weights[i] <= w) {
                sum += weights[i];
            } else {
                sum = weights[i];
                d++;
            }
        }

        return d <= days;
    }
}