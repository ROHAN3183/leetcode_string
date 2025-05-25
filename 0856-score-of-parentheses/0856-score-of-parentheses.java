class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        int score =0;
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push(0);
            }
            else if(!stack.isEmpty() && stack.peek()==0 && ch==')'){
                stack.pop();
                stack.push(1);
            }
            else if(!stack.isEmpty() && stack.peek()>0 && ch==')'){
                int sum=0;
                while(!stack.isEmpty() && stack.peek()>0){
                    sum=sum+stack.pop();
                }
                stack.push(2*sum);
            }
        }
        while(!stack.isEmpty()){
            score=score+stack.pop();
        }
        return score;
        
    }
}