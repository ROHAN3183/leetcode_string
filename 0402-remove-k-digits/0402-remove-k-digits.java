class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        int n =num.length();
        for(int i=0;i<n;i++){
            char ch=num.charAt(i);
            while(!stack.isEmpty() && stack.peek()>ch && k>0){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(k>0){
            stack.pop();
            k--;
        }
        char [] charArray=new char[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            charArray[i]=stack.pop();
        }
        String ans=new String(charArray);
        String result= ans.replaceFirst("^0+","");
        if(result.length()==0){
            return "0";
        }

        return result;
    }
}