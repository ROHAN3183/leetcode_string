class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        int n = nums1.length;
        long max=Long.MIN_VALUE;
        int[][] sorted = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            sorted[i][0] = nums1[i];
            sorted[i][1] = nums2[i];
        }
        Arrays.sort(sorted,(a,b)->Integer.compare(b[1],a[1]));
        int sum=0;
        for(int i=0;i<k-1;i++){
            sum+=sorted[i][0];
            minHeap.offer(sorted[i][0]);
        }
        for(int i=k-1;i<n;i++){
            sum+=sorted[i][0];
            minHeap.offer(sorted[i][0]);
            while(minHeap.size()>k){
                sum-= minHeap.poll();
            }
            max=Math.max(max,sorted[i][1]*sum);
        }
        return max;

    }
}