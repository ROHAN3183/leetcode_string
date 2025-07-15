class Solution {
    public long continuousSubarrays(int[] nums) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;

        int n = nums.length;
        int i = 0;
        int j = 0;

        while (j < n) {
            maxHeap.add(nums[j]);
            minHeap.add(nums[j]);
            while (Math.abs(minHeap.peek() - maxHeap.peek()) > 2) {
                maxHeap.remove(nums[i]);
                minHeap.remove(nums[i]);
                i++;
            }
            ans = ans + j - i + 1;
            j++;
        }
        return ans;

    }
}