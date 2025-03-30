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