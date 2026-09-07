class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return binarySearch(piles, h);
    }

    int binarySearch(int[] piles, int h) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isvalid(piles, mid, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    boolean isvalid(int[] piles, int time, int h) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += Math.ceil((double) piles[i] / time);
        }
        if (sum > h) {
            return false;
        }
        return true;
    }
}