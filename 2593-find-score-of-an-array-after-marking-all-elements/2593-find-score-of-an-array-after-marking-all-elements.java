import java.util.AbstractMap;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public long findScore(int[] nums) {
        // Priority queue to keep elements ordered by their value (min-heap)
        // If values are equal, we can choose the smaller index first (though problem doesn't specify)
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a.getKey().equals(b.getKey())) {
                    return Integer.compare(a.getValue(), b.getValue());
                }
                return Integer.compare(a.getKey(), b.getKey());
            }
        );

        // Add elements to the priority queue with (value, index) pairs
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new AbstractMap.SimpleEntry<>(nums[i], i));
        }

        boolean[] marked = new boolean[nums.length];
        long score = 0;

        // Process the elements in order of their value (min-heap)
        while (!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> element = minHeap.poll();
            int index = element.getValue();
            int value = element.getKey();

            // Only process the element if it has not been marked yet
            if (!marked[index]) {
                score += value;  // Add value to score
                marked[index] = true;  // Mark the current element

                // Mark neighbors (left and right)
                if (index > 0) {
                    marked[index - 1] = true;
                }
                if (index < nums.length - 1) {
                    marked[index + 1] = true;
                }
            }
        }
        return score;
    }
}