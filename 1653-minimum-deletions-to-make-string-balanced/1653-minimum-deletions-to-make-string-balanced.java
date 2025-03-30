class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> stack=new Stack();
        int delete=0;
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
            }
            else if(stack.peek()=='b' && ch=='a'){
                stack.pop();
                delete++;
            }
            else{
                stack.push(ch);
            }
        }
        return delete;
    }
}