******************************************LOGIC OF THE CODE********************************************************************
1) create the 2d array that include the sorted[i][0] is from the nums1  where as the sorted[i][1] is from the nums2 
2) sort on the basis of the sorted[i][1] in the descending order.
    remove the element from the minheap as the size of the window get the greater then the k.
3) calculate the max using sum*min.
********************************************************************************************************************************
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = nums1.length;
        long max = 0;
        int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = nums1[i];
            sorted[i][1] = nums2[i];
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(b[1], a[1]));
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sorted[i][0];
            minHeap.offer(sorted[i][0]);
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            if (minHeap.size() == k) {
                max = Math.max(max, sum * sorted[i][1]);
            }
        }
        return max;
    }
}
