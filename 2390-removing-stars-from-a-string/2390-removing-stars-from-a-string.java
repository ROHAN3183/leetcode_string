logic for the code : if character is  coming '*' then remove the peek of the stack else push it into the stack.
BRUTE FORCE
    
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        char[] charArray = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            charArray[i] = stack.pop();
        }
        String result = new String(charArray);
        return result;
    }
}
OPTIMIZED CODE
class Solution {
    public String removeStars(String s) {
        StringBuilder str=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch =s.charAt(i);
            if(ch=='*'){
                str.deleteCharAt(str.length()-1);
            }
            else{
                str.append(ch);
            }
        }
        String result=str.toString();
        return result;
    }
}
