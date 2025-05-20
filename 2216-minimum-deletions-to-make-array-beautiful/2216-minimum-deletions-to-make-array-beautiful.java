*****************************************************STACK************************************************************************
class Solution {
    public int minDeletion(int[] nums) {
        int n=nums.length;
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(stack.size()%2==0){//even length
                stack.push(nums[i]);
            }
            else if(stack.size()%2!=0){// odd length
                if(stack.peek()!=nums[i]){
                    stack.push(nums[i]);
                }
            }
        }
        if(stack.size()%2!=0){
            stack.pop();
        }
        return n-stack.size();
    }
}
********************************************OPTIMIZED CODE************************************************************************
class Solution {
    public int minDeletion(int[] nums) {
        int deletions = 0;
        int n = nums.length;
        int pos = 0; // current position in the new array
        for (int i = 0; i < n; i++) {
            if (pos % 2 == 0) {
                if (i + 1 < n && nums[i] == nums[i + 1]) {
                    deletions++;
                } else {
                    pos++;
                }
            } else {
                pos++;
            }
        }
        if (pos % 2 != 0) {
            deletions++;
        }
        return deletions;
    }
}
