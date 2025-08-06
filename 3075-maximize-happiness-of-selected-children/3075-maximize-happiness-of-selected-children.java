class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = happiness.length;
        int time = 0;
        long sum = 0;
        Arrays.sort(happiness);

        for (int i = n - 1; i >= 0; i--) {
            if (k <= 0) {
                return sum;
            }
            maxHeap.offer(happiness[i]);
            while (maxHeap.size() > k) {
                maxHeap.poll();
            }
            if (maxHeap.peek() - time >= 0) {
                sum = sum + maxHeap.poll() - time;
            }
            time++;
            k--;
        }
        return sum;
    }
}