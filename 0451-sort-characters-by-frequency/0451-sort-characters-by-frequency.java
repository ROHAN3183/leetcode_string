class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Map.Entry<Character,Integer>>minHeap=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        HashMap<Character,Integer> map=new HashMap<>();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer>entry: map.entrySet()){
            minHeap.offer(entry);

        }
        while(!minHeap.isEmpty()){
            Map.Entry<Character, Integer> entry = minHeap.poll();
            char ch =entry.getKey();
            int n=entry.getValue();
            for(int i=0;i<n;i++){
                str.append(ch);
            }
        }
        return str.reverse().toString();
    }
}