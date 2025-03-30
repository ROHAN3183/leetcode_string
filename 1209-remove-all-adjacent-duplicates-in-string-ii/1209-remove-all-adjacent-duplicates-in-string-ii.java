class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack=new Stack();
        StringBuilder final_result=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(!stack.isEmpty() && stack.peek().ch==ch){
                stack.peek().count++;
            }
            else{
                stack.push(new Pair(ch,1));
            }
            if(stack.peek().count==k){
                stack.pop();
            }

        }
        while(!stack.isEmpty()){
            Pair current=stack.pop();
            for(int i=0;i<current.count;i++){
                final_result.append(current.ch);
            }
        }
        return final_result.reverse().toString();
    }
}
class Pair{
    char ch;
    int count;
    Pair(char ch,int count){
        this.ch=ch;
        this.count=count;
    }
}