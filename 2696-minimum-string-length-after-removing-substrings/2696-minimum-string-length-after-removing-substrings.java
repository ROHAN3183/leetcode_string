class Solution {
    public int minLength(String s) {
        int n=s.length();
        Stack<Character> stack=new Stack();
        for(int i=0;i<n;i++){
            char ch =s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
            }
            else if((stack.peek()=='A' && ch=='B')||(stack.peek()=='C'&&ch=='D')){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        if(stack.size()>0){
            return stack.size();
        }
        return 0;
    }
}