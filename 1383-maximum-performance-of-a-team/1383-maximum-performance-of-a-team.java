class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[][] sorted = new int[n][2];
        int mod = 1_000_000_007;
        for (int i = 0; i < n; i++) {
            sorted[i][0] = speed[i];
            sorted[i][1] = efficiency[i];
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(b[1], a[1]));
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            sum += sorted[i][0];
            minHeap.add(sorted[i][0]);
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            max = Math.max(max, sum * sorted[i][1]);
        }
        return (int)(max % mod);
    }
}