class Solution {
    public int minSetSize(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int i : map.values()){
            pq.offer(i);
        }
        int  sum =0;
        int count=0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
            count++;
            if(sum>=nums.length/2){
                break;
            }
        }
        return count;

    }
}