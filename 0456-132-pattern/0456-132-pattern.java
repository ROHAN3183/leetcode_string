class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int num2=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<num2){
                return true;
            }
            while(!stack.isEmpty() && stack.peek()<nums[i]){
                    num2=stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}