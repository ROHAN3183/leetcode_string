*********************************************BETTER CODE***********************************************************************
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeSet<Integer> set = new TreeSet<>();
        int n = nums.length;
        int i = 0;
        int j = 0;
        int size = 0;
        while (j < n) {
            set.add(nums[j]);
            while ((set.last() - set.first()) > limit) {
                set.remove(nums[i]);
                i++;
            }
            size = Math.max(size, j - i + 1);
            j++;
        }
        return size;
    }
}
*******************************************LOGIC OF THE CODE********************************************************************
From the heap delete the element which is creating the problem for the given condition that is greater then the limit .
whenever the condition become the wrong we need to delete the element from the heap who whoever having the min idx on the heap peek
either from the min or max heap ,and make the  i = min (minheapIdx ,maxheapIdx) + 1.

*******************************************OPTIMIZED CODE**********************************************************************
class Solution {

    class Pair {
        int key;
        int idx;

        Pair(int key, int idx) {
            this.key = key;
            this.idx = idx;
        }
    }

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.key - b.key);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.key - a.key);
        int n = nums.length;
        int i = 0;
        int j = 0;
        int size = 0;
        while (j < n) {
            minHeap.offer(new Pair(nums[j], j));
            maxHeap.offer(new Pair(nums[j], j));
            if ((maxHeap.peek().key - minHeap.peek().key) > limit) {
                i = Math.min(maxHeap.peek().idx, minHeap.peek().idx) + 1;
                while (maxHeap.peek().idx < i) {
                    maxHeap.poll();
                }
                while (minHeap.peek().idx < i) {
                    minHeap.poll();
                }
            }
            size = Math.max(j - i + 1, size);
            j++;
        }
        return size;
    }
}
