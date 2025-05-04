class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long>minHeap=new PriorityQueue<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            minHeap.add((long)nums[i]);
        }
        int count=0;

        while(minHeap.size()>=2 && minHeap.peek()<k){
            long x=minHeap.poll();
            long y=minHeap.poll();
            long result=(Math.min(x,y)*2 + Math.max(x,y));
            minHeap.add(result);
            count++;
        }
    return count;
    }
}