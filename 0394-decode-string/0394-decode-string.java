Logic of the code:
1) take two stack first for storing the character like a,b,[,] .. another for storing digit like 1,2,33...
2) to convert two digit trick is num=num*10 +(ch-'0')
3) whenever '[' then push num into stack
4) whenever ']' then push back reversed timced string into stack.
    
class Solution {
    public String decodeString(String s) {
        
        Stack<Character> stack=new Stack();
        Stack<Integer> time_stack=new Stack();
        StringBuilder result=new StringBuilder();

        int num=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(Character.isDigit(ch)){
                num=num*10 +(ch-'0');
            }
            else if(ch=='['){
                time_stack.push(num);
                num=0;
                stack.push(ch);

            }
            else if(ch==']'){
                StringBuilder str= new StringBuilder();
                StringBuilder ans=new StringBuilder();
                while(!stack.isEmpty()&& stack.peek()!='['){
                    str.append(stack.pop());
                }
                str.reverse();
                 stack.pop();// to remove [
                int times=time_stack.pop();

                for(int j=0;j<times;j++){
                    ans.append(str);
                }

                for(char c : ans.toString().toCharArray()){

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
