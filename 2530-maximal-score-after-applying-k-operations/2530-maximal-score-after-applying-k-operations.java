class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long score = 0;

        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }

        while (k > 0) {
            score += maxHeap.peek();
            int popped = maxHeap.poll();
            int pushed = (int)Math.ceil((double)popped / 3);
            maxHeap.offer(pushed);
            k--;
        }

        return score;

    }
}