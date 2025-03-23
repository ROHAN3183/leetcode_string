logic for the code 
1) pop out the element from the stack.
2) push out the element.
    
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int n=pushed.length;
        int m=popped.length;
        int j=0;
        for(int i=0;i<m ;i++){
            
            stack.push(pushed[i]);

            while(!stack.isEmpty() && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
