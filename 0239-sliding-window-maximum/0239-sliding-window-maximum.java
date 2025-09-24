import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>(); // stores indices
        int n = nums.length;
        int idx = 0;
        int[] result = new int[n - k + 1];

        // First window
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i); // store index
        }
        result[idx++] = nums[dq.peekFirst()]; // take max from index

        // Remaining windows
        for (int i = k; i < n; i++) {
            // remove indices out of this window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            result[idx++] = nums[dq.peekFirst()];
        }

        return result;
    }
}
