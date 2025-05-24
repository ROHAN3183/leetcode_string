class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        Stack<Character>stack=new Stack<>();
        int score =0;

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!stack.isEmpty() && stack.peek()=='(' && ch==')'){
                stack.pop();
                score++;
            }
            else{
                stack.push(ch);
            }
        }
        return score;
    }
}