class Solution {

   static class Pair {
        int distance;
        double time;

        Pair(int distance, double time) {
            this.distance = distance;
            this.time = time;
        }

    }

    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.distance - a.distance);
        int fleet=0;
        int size = position.length;
        for (int i = 0; i < size; i++) {
            int d = position[i];
            double time = (double)(target-position[i]) / speed[i];
            maxHeap.offer(new Pair(d, time));
        }
        double minTime=-1;
        while(!maxHeap.isEmpty()){
            Pair popped=maxHeap.poll();
            if(popped.time>minTime){
                fleet++;
                minTime=popped.time;
            }

        }
        return fleet;

    }
}