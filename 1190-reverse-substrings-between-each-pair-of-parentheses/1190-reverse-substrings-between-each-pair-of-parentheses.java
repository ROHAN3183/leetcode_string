class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack=new Stack();
        StringBuilder result=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
            }
            else if(!stack.isEmpty()&& ch==')'){
                StringBuilder str=new StringBuilder();
                while(!stack.isEmpty()&&stack.peek()!='('){
                    str.append(stack.pop());
                }
                stack.pop();
                for(char c: str.toString().toCharArray()){
                    stack.push(c);
                }
            }
            else{
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}