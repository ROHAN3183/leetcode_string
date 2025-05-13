import java.util.AbstractMap;
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n1 =colors.length();
        int n2=neededTime.length;
        int count=0;
        Stack<Map.Entry<Character,Integer>> stack=new Stack<>();

        for(int i=0;i<n1;i++){
            if(stack.isEmpty()){
                stack.push(new AbstractMap.SimpleEntry<>(colors.charAt(i),neededTime[i]));
            }
            else{
                Map.Entry<Character,Integer> temp=stack.peek();
                if(temp.getKey()==colors.charAt(i) &&temp.getValue()<neededTime[i]){
                    count=count+temp.getValue();
                    stack.pop();
                    stack.push(new AbstractMap.SimpleEntry<>(colors.charAt(i),neededTime[i]));
                }
                else if(temp.getKey()==colors.charAt(i) &&temp.getValue()>neededTime[i]){
                    count=count+neededTime[i];
                    continue;
                }
                else if(temp.getKey()!=colors.charAt(i)){
                    stack.push(new AbstractMap.SimpleEntry<>(colors.charAt(i),neededTime[i]));
                }

            }
        }
        return count;

    }
}