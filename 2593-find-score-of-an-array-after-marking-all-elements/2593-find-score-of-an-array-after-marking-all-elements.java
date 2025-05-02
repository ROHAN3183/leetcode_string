import java.util.AbstractMap;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public long findScore(int[] nums) {
        // Priority queue to keep elements ordered by their value (min-heap)
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.getKey(), b.getKey()) // Min-heap based on the value of nums[i]
        );

        // Add elements to the priority queue with (value, index) pairs
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new AbstractMap.SimpleEntry<>(nums[i], i));
        }

        int n = nums.length;
        boolean[] marked = new boolean[n];
        Arrays.fill(marked, false);  // Mark all elements as unvisited initially
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

                // Mark neighbors (left and right) only if they have not been marked
                if (index - 1 >= 0 && !marked[index - 1]) {
                    marked[index - 1] = true;
                }
                if (index + 1 < n && !marked[index + 1]) {
                    marked[index + 1] = true;
                }
            }
        }
        return score;
    }
}
