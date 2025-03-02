class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int n=s.length();
        int number=0;
        char lastOperator='+';
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                number=number*10+(ch-'0');
            }
            if((!Character.isDigit(ch) && ch != ' ') || i == n - 1){
                if(lastOperator=='+'){
                    stack.push(number);
                }
                else if(lastOperator=='-'){
                    stack.push(-number);
                }
                else if(lastOperator=='*'){
                    stack.push(stack.pop()*number);
                }
                else if(lastOperator=='/'){
                    stack.push(stack.pop()/number);
                }
                lastOperator=ch;
                number=0;
            }
        }
        int result=0;
        while(!stack.isEmpty()){
            result=result+stack.pop();
        }
        return result;
    }
}