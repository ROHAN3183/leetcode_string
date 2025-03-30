logic of the code: 
1) if top of the stack is '[' and comming is ']' then no issue. pop() out.
2) remaining the stack of the stack will contain both '[' and ']' we need to count the either ']' or '[' size of the ('['+1)/2;

class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack=new Stack();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
            }
            else if(stack.peek()=='[' && ch==']'){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        if(!stack.isEmpty()){
            int size=stack.size()/2;
            return (size+1)/2;
        }
    return 0;
    }
}
