class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        int n=piles.length;
        for(int i=0;i<n;i++){
            maxHeap.add(piles[i]);
        }
        int count=0;

        while(count<k){
            int peek_element=maxHeap.poll();
            //int pop_element=(int)Math.ceil(peek_element/2.0);
            int pop_element=(peek_element+1)/2;
            maxHeap.add(pop_element);
            count++;

        }
        int result_sum=0;
        while(!maxHeap.isEmpty()){
            result_sum+=maxHeap.poll();
        }
    return result_sum;
    }
}