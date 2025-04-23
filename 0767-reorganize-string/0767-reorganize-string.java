import java.util.AbstractMap;
class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        int []freq=new int [26];

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
            if(freq[ch-'a']>(n+1)/2){
                return "";
            }
        }
        PriorityQueue<Map.Entry<Character,Integer>>maxHeap=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        StringBuilder result=new StringBuilder();
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                char ch=(char)('a'+i);
                maxHeap.add(new AbstractMap.SimpleEntry<>(ch,freq[i]));
            }
        }

        while(maxHeap.size()>=2){
            Map.Entry<Character,Integer> current=maxHeap.poll();
            Map.Entry<Character,Integer> next=maxHeap.poll();

            result.append(current.getKey());
            result.append(next.getKey());

            if(current.getValue()>1){
                int newvalueC=current.getValue()-1;
                maxHeap.add(new AbstractMap.SimpleEntry<>(current.getKey(),newvalueC));
            }
            if(next.getValue()>1){
                int newvalueN=next.getValue()-1;
                maxHeap.add(new AbstractMap.SimpleEntry<>(next.getKey(),newvalueN));
            }


        }
        while(!maxHeap.isEmpty()){
            Map.Entry<Character,Integer>rest=maxHeap.poll();
            result.append(rest.getKey());
        }
        return result.toString();
    }
}