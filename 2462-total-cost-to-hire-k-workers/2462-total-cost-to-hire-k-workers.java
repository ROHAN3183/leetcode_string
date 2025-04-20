class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n=costs.length;
        int i=0;
        int j=n-1;
        long result=0;
        PriorityQueue<Integer>minHeapLeft=new PriorityQueue<>();
        PriorityQueue<Integer>minHeapRight=new PriorityQueue<>();
        int number=0;
        while(number<k){
            while(minHeapLeft.size()<=candidates && i<=j){
                minHeapLeft.add(costs[i]);
                i++;
            }
            while(minHeapRight.size()<=candidates && i<=j){
                minHeapRight.add(costs[j]);
                j--;
            }
            
            if(!minHeapLeft.isEmpty() && !minHeapRight.isEmpty()){

                if(minHeapLeft.peek()<=minHeapRight.peek()){
                    result=result+minHeapLeft.peek();
                    minHeapLeft.poll();
                }
                else{
                    result=result+minHeapRight.peek();
                    minHeapRight.poll();
                }

            }
            else if(!minHeapLeft.isEmpty()){
                result+=minHeapLeft.poll();
            }
            else if(!minHeapRight.isEmpty()){
                result+=minHeapRight.poll();
            }

            number++;
        }
        return result;
    }
}