
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        List<int[]> result = new ArrayList<>();

        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        int i = 1;

        while (i < n) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            while (i < n && currentEnd >= nextStart) {
                currentEnd = Math.max(currentEnd, nextEnd);
                i++;
                if (i < n) {
                    nextStart = intervals[i][0];
                    nextEnd = intervals[i][1];
                }
            }

            result.add(new int[] { currentStart, currentEnd });

            if (i < n) {
                currentStart = intervals[i][0];
                currentEnd = intervals[i][1];
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
