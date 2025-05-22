class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int fullTank = capacity;
        int count = 0;
        int i = 0;
        while (i < n) {
            if (capacity >= plants[i]) {
                capacity = capacity - plants[i];
                count = count + 1;
                // Only increment after watering
            } else {
                capacity = fullTank;
                capacity=capacity-plants[i];
                count = count + 2 * (i + 1)-1; // Remove the -1
                // Do not increment i here
            }
            i++;
        }
        return count;
    }
}