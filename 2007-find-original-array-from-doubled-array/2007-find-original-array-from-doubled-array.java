class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        // If the length is odd, we cannot form pairs, so return an empty array.
        if (n % 2 != 0) {
            return new int[] {};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[n / 2];
        // Count the frequencies of each number in the 'changed' array
        for (int num : changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int idx = 0;
        // Process each element in the 'changed' array
        for (int i = 0; i < n; i++) {
            int num = changed[i];
            
            // Skip if this number has already been processed (its frequency is 0)
            if (map.get(num) == 0) {
                continue;
            }

            // If we can pair the number 'num' with its double '2 * num'
            if (map.getOrDefault(2 * num, 0) > 0) {
                // Record the original element in the result array
                res[idx++] = num;
                // Decrement the count for 'num' and '2 * num'
                map.put(num, map.get(num) - 1);
                map.put(2 * num, map.get(2 * num) - 1);
            } else {
                // If no valid pair is found, return an empty array
                return new int[] {};
            }
        }
        return res;
    }
}
