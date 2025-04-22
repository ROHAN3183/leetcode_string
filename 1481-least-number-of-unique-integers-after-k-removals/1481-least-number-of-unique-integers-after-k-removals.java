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
        int size=map.size();
        while(k>0 && !minHeap.isEmpty()){
            Map.Entry<Integer,Integer>entry=minHeap.poll();

            int fre=entry.getValue();
            if(k>=fre){
                k-=fre;
                size--;
            }

        }
        return size;
    }
}