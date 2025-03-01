class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int n=s.length();
        int number=0;
        int result=0;
        int sign=1;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                number=number*10 + (ch-'0');
            }
            else if(ch=='+'){
                result=result+(sign*number);
                sign=1;
                number=0;
            }
            else if(ch=='-'){
                result=result+(sign*number);
                sign=-1;
                number=0;
            }
            else if(ch=='('){
                stack.push(result);
                stack.push(sign);
                result=0;
                sign=1;

            }
            else if(ch==')'){
                result=result+number*sign;
                number=0;
                int stack_sign=stack.pop();
                result=result*stack_sign;
                int stack_result=stack.pop();
                result=result+stack_result;
            }
        }
        result=result+sign*number;
        return result;
    }
}