class Solution {
    public String minRemoveToMakeValid(String s) {
        int n=s.length();
        int open=0;
        int close=0;
        Stack<Character>stack=new Stack<>();
        StringBuilder result=new StringBuilder();


        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(ch=='('){
                open++;
                stack.push(ch);
            }
            else if(ch==')'){
                if(open>0){
                    open--;
                    stack.push(ch);
                }
            }
            else{
                stack.push(ch);
            }

        }
        while(!stack.isEmpty()){

            char ch=stack.pop();
            if(ch=='(' && open>0){
                open--;
            }
            else{
                result.append(ch);
            }
        }

        return result.reverse().toString();
    }
}