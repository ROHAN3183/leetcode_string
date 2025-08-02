class Solution {
    class Pair {
        int first;
        int second;
        double frac;

        Pair(int first, int second, double frac) {
            this.first = first;
            this.second = second;
            this.frac = frac;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.frac, a.frac));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double frac = (double) arr[i] / arr[j];
                maxHeap.offer(new Pair(arr[i], arr[j], frac));
                while (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return new int[] { maxHeap.peek().first, maxHeap.peek().second };

    }
}