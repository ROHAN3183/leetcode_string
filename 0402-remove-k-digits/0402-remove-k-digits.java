logic of the code:
Always increasing number is smaller ex-1234 is smaller then 1243 so use the concept of the monostack means alway push the digit
which is greater then the previous oone or peek() . else keep deleting it also remember the delete the digit from the stack only
k time.if after pushing in the stack also k didn't got 0 means need to  delete the last digit from the k stack because it is greater.
    
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
