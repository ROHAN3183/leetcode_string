import java.util.AbstractMap;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map =new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>>minHeap=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        int n=arr.length;
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            minHeap.add(entry);
        }
        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> entry=minHeap.peek();
            if(entry.getValue()<=1){
                minHeap.poll();
                
            }
            else{
                
                entry=minHeap.poll();
                int count=entry.getValue()-1;
                minHeap.add(new AbstractMap.SimpleEntry<>(entry.getKey(),count));
            }
        }
        int result=0;
        while(!minHeap.isEmpty()){
            minHeap.poll();
            result++;
        }

    return result;
    }
}