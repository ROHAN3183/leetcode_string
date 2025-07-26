***************************************LOGIC OF THE CODE***********************************************************************
First store the (-k ,+k ) in the list .
Sort on the basis of the start.
Maintain the Dequeue push at the last.
if coming is start is greater the peek of the end it mean's on overlapping ,so no need to keep it always track the size of the 
Dequeue.
***************************************OPTIMIZED CODE**************************************************************************
class Solution {
    class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int maximumBeauty(int[] nums, int k) {
        Deque<Pair> dq = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            list.add(Arrays.asList(nums[i] - k, nums[i] + k));
        }
        Collections.sort(list, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        for (int i = 0; i < nums.length; i++) {

            while (!dq.isEmpty() && dq.peekFirst().end < list.get(i).get(0)) {
                dq.pollFirst();
            }
            dq.offerLast(new Pair(list.get(i).get(0), list.get(i).get(1)));
            size = Math.max(size, dq.size());

        }
        return size;

    }
}
