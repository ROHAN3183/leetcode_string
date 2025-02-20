class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer>stack=new Stack<>();
        int n=nums.length;
        int []ans=new int[n];
        for(int i=2*n-1;i>=0;i--){
            int element=nums[i%n];
            if(stack.isEmpty()){
                stack.push(element);
                ans[i%n]=-1;
            }
            else{
                if(!stack.isEmpty()&& stack.peek()>=element){
                    ans[i%n]=stack.peek();
                }
                while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    ans[i%n]=stack.peek();
                }
                else{
                    ans[i%n]=-1;
                }
                stack.push(element);
            }
        }
        return ans;
    }
}