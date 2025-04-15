class MedianFinder {
    private PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
   private  PriorityQueue<Integer> minHeap=new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
        }
        else if(minHeap.isEmpty()){
            minHeap.add(num);
        }
        else if (minHeap.size()==maxHeap.size()){
            minHeap.add(num);
            if(minHeap.size()>maxHeap.size()){
                int value=minHeap.poll();
                maxHeap.add(value);
            }
        }
        else if(minHeap.size()<maxHeap.size()){
            minHeap.add(num);
        }
        
    }
    
    public double findMedian() {
        int size1=minHeap.size();
        int size2=maxHeap.size();
        int size=size1+size2;
        double result=0;

        if(size%2==0){
            result=(minHeap.peek()+maxHeap.peek())/2.0;
        }
        else{
            result=maxHeap.peek();
        }

        return result;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */