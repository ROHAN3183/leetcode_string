class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        int maxIdx = -1;
        int minIdx = -1;

        // Find the global maximum and minimum values with their indices
        for (int i = 0; i < n; i++) {
            int largest = arrays.get(i).get(arrays.get(i).size() - 1);
            if (largest > maximum) {
                maximum = largest;
                maxIdx = i;
            }

            int smallest = arrays.get(i).get(0);
            if (smallest < minimum) {
                minimum = smallest;
                minIdx = i;
            }
        }

        // If max and min come from different arrays, return their difference
        if (maxIdx != minIdx) {
            return maximum - minimum;
        }

        // If max and min come from the same array,
        // try to find max distance using other arrays
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == maxIdx) continue;

            int currentMax = arrays.get(i).get(arrays.get(i).size() - 1);
            result = Math.max(result, Math.abs(currentMax - minimum));

            int currentMin = arrays.get(i).get(0);
            result = Math.max(result, Math.abs(maximum - currentMin));
        }

        return result;
    }
}
