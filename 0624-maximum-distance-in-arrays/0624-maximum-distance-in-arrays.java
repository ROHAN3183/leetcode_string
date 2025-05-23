

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int minIdx = -1;
        int maxIdx = -1;
        
        // Find the two smallest minima and their indices
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int currentMin = array.get(0);
            if (currentMin < min1) {
                min2 = min1;
                min1 = currentMin;
                minIdx = i;
            } else if (currentMin < min2) {
                min2 = currentMin;
            }
        }
        
        // Find the two largest maxima and their indices
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int currentMax = array.get(array.size() - 1);
            if (currentMax > max1) {
                max2 = max1;
                max1 = currentMax;
                maxIdx = i;
            } else if (currentMax > max2) {
                max2 = currentMax;
            }
        }
        
        // If the min and max are from different arrays, return their difference
        if (minIdx != maxIdx) {
            return max1 - min1;
        } else {
            // Otherwise, return the maximum of (max1 - min2) and (max2 - min1)
            return Math.max(max1 - min2, max2 - min1);
        }
    }
}