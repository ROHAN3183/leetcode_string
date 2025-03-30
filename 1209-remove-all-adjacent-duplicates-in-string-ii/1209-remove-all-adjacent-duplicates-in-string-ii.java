logic of the code:
1) push character to the stack, write manipulation function which perform an operation like pop out k from the stack and check 
2)  wheather the all the character are same or not if not same then push back to the reverse order .alway convert stringBuilder 
    to the .toString.toCharArray().
#BRUTE CODE
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder final_result = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            stack.push(ch);
            manipulation(stack, k);
        }

        while(!stack.isEmpty()){
            final_result.append(stack.pop());
        }
        return final_result.reverse().toString();
    }

    private void manipulation(Stack<Character> stack, int k){
        if(stack.size() < k) return;

        boolean flag = true;
        StringBuilder str = new StringBuilder();
        int count = 0;

        while(!stack.isEmpty() && count < k){
            str.append(stack.pop());
            count++;
        }

        char[] result = str.toString().toCharArray();

        for(int j = 1; j < result.length; j++){
            if(result[j] != result[j - 1]){
                flag = false;
                break;
            }
        }

        if(!flag){
            for(int m = result.length - 1; m >= 0; m--){
                stack.push(result[m]);
            }
        }
    }        
}

#2 OPTIMIZED CODE
logic of the code:
1)Take a stack that consist of the Pair of Character and Int.
2)during the pushing into the stack if character at the top of th stack is similar then then increase the count.
3 otherwise create new pair with (ch,1)
4 if stack.peek().count==k then pop() out it.
    
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack=new Stack();
        StringBuilder final_result=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(!stack.isEmpty() && stack.peek().ch==ch){
                stack.peek().count++;
            }
            else{
                stack.push(new Pair(ch,1));
            }
            if(stack.peek().count==k){
                stack.pop();
            }

        }
        while(!stack.isEmpty()){
            Pair current=stack.pop();
            for(int i=0;i<current.count;i++){
                final_result.append(current.ch);
            }
        }
        return final_result.reverse().toString();
    }
}
class Pair{
    char ch;
    int count;
    Pair(char ch,int count){
        this.ch=ch;
        this.count=count;
    }
}
