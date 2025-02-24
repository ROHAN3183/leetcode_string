logic of the code :
if comming string is not number means 1,2,etc  then pop out first two digit from the stack and perform some operation with the
coming string otherwise just put it into the stack by converting it into the integer. 

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        int n=tokens.length;
        int first=0;
        int second=0;
        for(int i=0;i<n;i++){
           boolean flag=false;
            String s=tokens[i];
            while(!stack.isEmpty() &&  (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))){
                second=stack.pop();
                first=stack.pop();
                flag=true;
                break;
            }
            if(flag==true && s.equals("+")){
                stack.push(first+second);
            }
            else if(flag==true && s.equals("-")){
                stack.push(first-second);
            }
            else if(flag==true && s.equals("*")){
                stack.push(first*second);
            }
            else if(flag==true && s.equals("/")){
                stack.push(first/second);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}
