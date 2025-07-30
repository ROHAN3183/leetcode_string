******************************************LOGIC OF THE CODE********************************************************************
1) create the 2d array that include the sorted[i][0] is from the nums1  where as the sorted[i][1] is from the nums2 
2) sort on the basis of the sorted[i][1] in the descending order.
3) start the loop till the k-2 and store the sum of the all the sorted[i][0] till the k-2.
4) again start the loop from the k-1 to n so that we can find the min element from the nums2 also when loop will go forward then 
    remove the element from the minheap as the size of the window get the greater then the k.
5) calculate the max using sum*min.
********************************************************************************************************************************
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = nums1.length;
        long max = Long.MIN_VALUE;
        int[][] sorted = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            sorted[i][0] = nums1[i];
            sorted[i][1] = nums2[i];
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(b[1], a[1]));
        long sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += sorted[i][0];
            minHeap.offer(sorted[i][0]);
        }
        for (int i = k - 1; i < n; i++) {
            sum += sorted[i][0];
            minHeap.offer(sorted[i][0]);
            while (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            max = Math.max(max, sorted[i][1] * sum);
        }
        return max;

    }
}
