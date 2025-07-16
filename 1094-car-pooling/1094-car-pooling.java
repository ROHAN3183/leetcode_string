class Solution {
    class Trip {
        int numPassengers;
        int start;
        int end;

        Trip(int numPassengers, int start, int end) {
            this.numPassengers = numPassengers;
            this.start = start;
            this.end = end;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<Trip> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
        int currentPassenger = 0;

        for (int i = 0; i < trips.length; i++) {
            while (!minHeap.isEmpty() && minHeap.peek().end <= trips[i][1]) {
                currentPassenger -= trips[i][0];
            }

            currentPassenger += trips[i][0];

            if (currentPassenger > capacity){
                return false;
            }    
            minHeap.add(new Trip(trips[i][0], trips[i][1], trips[i][2]));
        }
        return true;
    }
}