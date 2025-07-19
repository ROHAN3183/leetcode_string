class Solution {
    class Pair {
        long sum;
        int idx;

        Pair(long sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a.sum, b.sum));

        List<Long> list = new ArrayList<>();
        long result = 0;
        int mod = 1_000_000_007;

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new Pair((long) nums[i], i));
        }

        while (!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            list.add(pair.sum);
            if (pair.idx + 1 < n) {
                minHeap.add(new Pair(pair.sum + nums[pair.idx + 1], pair.idx + 1));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (i >= left - 1 && i < right) {
                result = (result + list.get(i)) % mod;
            }
        }
        return (int) result;
    }
}