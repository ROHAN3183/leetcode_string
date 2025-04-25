import java.util.AbstractMap;
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder str=new StringBuilder();
        PriorityQueue<Map.Entry<Character,Integer>>maxHeap=new PriorityQueue<>((x,y)->y.getValue()-x.getValue());
        if(a>0){
            maxHeap.add(new AbstractMap.SimpleEntry<>('a',a));
        }
        if(b>0){
            maxHeap.add(new AbstractMap.SimpleEntry<>('b',b));
        }
        if(c>0){
            maxHeap.add(new AbstractMap.SimpleEntry<>('c',c));
        }
        while(!maxHeap.isEmpty()){
            Map.Entry<Character,Integer>temp1=maxHeap.poll();
            if(str.length()>=2 && str.charAt(str.length()-1)==temp1.getKey() &&
                str.charAt(str.length()-2)==temp1.getKey() ){
                if(!maxHeap.isEmpty()){
                    Map.Entry<Character,Integer> temp2=maxHeap.poll();
                    str.append(temp2.getKey());
                    int newValue2=temp2.getValue()-1;
                    if(newValue2>0){
                        maxHeap.add(new AbstractMap.SimpleEntry<>(temp2.getKey(),newValue2));
                    }
                }
                else{
                    break;
                }
                maxHeap.add(temp1);
            }
            else{
                str.append(temp1.getKey());
                int newValue1=temp1.getValue()-1;
                if(newValue1>0){
                    maxHeap.add(new AbstractMap.SimpleEntry<>(temp1.getKey(),newValue1));
                }
            }

        }
        return str.toString();
    }
}