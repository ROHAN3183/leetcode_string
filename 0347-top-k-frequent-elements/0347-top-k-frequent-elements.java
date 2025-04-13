class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int result[]=new int[k];
        HashMap<Integer,Integer>map=new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap=new PriorityQueue<>
        ((a,b)->b.getValue()-a.getValue());
        int n=nums.length;

        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        }
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            maxHeap.add(entry);
        }

        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> entry=maxHeap.poll();
            result[i]=entry.getKey();
        }
    return result;
    }
}