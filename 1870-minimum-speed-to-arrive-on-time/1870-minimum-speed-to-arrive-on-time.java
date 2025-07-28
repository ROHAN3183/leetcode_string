class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        int ans = -1;
        while (low <= high) {
            int speed = low + (high - low) / 2;
            if (isValid(dist, hour, speed)) {
                ans = speed;
                high = speed - 1;
            } else {
                low = speed + 1;
            }
        }
        return ans;
    }

    boolean isValid(int[] dist, double hour, int speed) {
        double hourCount = 0;
        for (int i = 0; i < dist.length; i++) {
            hourCount += Math.ceil(dist[i] / speed);
        }
        if (hourCount <= hour) {
            return true;
        }
        return false;
    }
}