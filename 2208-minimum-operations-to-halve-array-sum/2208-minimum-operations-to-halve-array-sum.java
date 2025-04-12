class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        int n=nums.length;
        double sum=0;
        int count=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        double half_sum=sum;
        for(int i=0;i<n;i++){
            maxHeap.add((double)nums[i]);
        }
        while(half_sum>sum/2){
            double greatestElement=maxHeap.poll();
            double half_result=(greatestElement)/2;
            half_sum=half_sum-half_result;
            maxHeap.add(half_result);
            count++;

        }
        return count;
    }
}