/*logic of the code:
Alway add to the answer j-i+1 whenever it is valid else remove it from the priorityQueue.
*/
*********************************************BETTER FORCE***********************************************************************
class Solution {
    public long continuousSubarrays(int[] nums) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;

        int n = nums.length;
        int i = 0;
        int j = 0;

        while (j < n) {
            maxHeap.add(nums[j]);
            minHeap.add(nums[j]);
            while (Math.abs(minHeap.peek() - maxHeap.peek()) > 2) {
                maxHeap.remove(nums[i]);
                minHeap.remove(nums[i]);
                i++;
            }
            ans = ans + j - i + 1;
            j++;
        }
        return ans;

    }
}
***************************************************OPTIMIZED CODE**************************************************************
/*
logic of the code:
Alway add to the answer j-i+1 whenever it is valid else remove it from the TreeMap having the feature of accessing from the both.
map.firstKey() give the key value and the map.lastKey() give the last key of the value by default it is sorted in the acsending 
order.
*/
class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int i = 0;
        int j = 0;
        long count = 0;

        while (j < n) {

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while ((map.lastKey() - map.firstKey()) > 2) {
                int freq = map.get(nums[i]);
                if (freq == 1) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                }
                i++;
            }

            count = count + j - i + 1;

            j++;

        }
        return count;

    }
}
