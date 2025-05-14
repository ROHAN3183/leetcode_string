class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 1) {
            return 1;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int prevEnd = points[0][1];
        int count = 1;
        int i = 1;
        int currentStart = points[i][0];

        while (i < n) {
            if (prevEnd < currentStart) {
                count++;
                prevEnd = points[i][1];
                i++;
                if (i < n) {
                    currentStart = points[i][0];
                }
            } else {
                // Overlapping, update prevEnd to the minimum end
                prevEnd = Math.min(prevEnd, points[i][1]);
                i++;
                if (i < n) {
                    currentStart = points[i][0];
                }
            }
        }

        return count;
    }
}
