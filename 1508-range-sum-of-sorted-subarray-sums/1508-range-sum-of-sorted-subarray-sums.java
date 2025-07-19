
***********************************************BRUTE FORCE**********************************************************************
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int size = nums.length;
        List<Long> list = new ArrayList<>();
        int mod = 1_000_000_007;
        for (int i = 0; i < size; i++) {
            long sum = 0;
            for (int j = i; j < size; j++) {
                sum = (sum + nums[j]) % mod;
                list.add(sum);
            }
        }
        Collections.sort(list);
        long sum = 0;

        for (int i = left - 1; i < right; i++) {
            sum = (sum + list.get(i)) % mod;
        }
        return (int) sum;

    }
}
................................................................................................................................
/*logic of the code : 
interesting property of the priorityQueue is that it can give the sum of all the possible subarray in the sorted order.
it can be achieve by first add all the element with the index and after that pop the peek and add to the sum  and after that 
push the next index of the poped with the (sum ,index ).
*/
******************************************************OPTIMIZED CODE************************************************************
class Solution {
    class Pair {
        long sum;
        int idx;

        Pair(long sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a.sum, b.sum));
        long result = 0;
        int mod = 1_000_000_007;

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new Pair((long) nums[i], i));
        }

        int count = 0;
        while (!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            count++;

            if (count >= left && count <= right) {
                result = (result + pair.sum) % mod;
            }

            if (pair.idx + 1 < n) {
                minHeap.add(new Pair(pair.sum + nums[pair.idx + 1], pair.idx + 1));
            }

            if (count == right)
                break;
        }

        return (int) result;
    }
}
