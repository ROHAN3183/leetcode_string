class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int mod = 1000000007;
        long result = 1;
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        while (!pq.isEmpty() && k > 0) {
            int temp = pq.poll();
            pq.offer(temp + 1);
            k--;
        }
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            result = (result * (temp)) % mod;
        }
        return (int) result;
    }
}