class Solution {
    public String decodeString(String s) {
       Stack<Character> stack=new Stack();
       Stack<Integer> time=new Stack();
       StringBuilder final_result=new StringBuilder();
       int num=0;
       for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(Character.isDigit(ch)){
            num=num*10+(ch-'0');
        }
        else if(ch=='['){
            time.push(num);
            num=0;
            stack.push(ch);
        }
        else if(ch==']'){
            StringBuilder str= new StringBuilder();
            StringBuilder result=new StringBuilder();
                while(!stack.isEmpty()&& stack.peek()!='['){
                    str.append(stack.pop());
                }
                stack.pop();
                str.reverse();
                for(int j=0;j<time.peek();j++){
                    result.append(str);
                }

                int times=time.pop();

            for(char c : result.toString().toCharArray())
                stack.push(c);
            }

        else{
                stack.push(ch);
            }

        }
        while(!stack.isEmpty()){
            final_result.append(stack.pop());
        }
        return final_result.reverse().toString();
    }
}