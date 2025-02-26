logic for the code 
take num1<num2<num3. 
It means num3 is alway largest so .if in stack smaller element is comming the push it into the stack
otherwise pop() put means because poped out element can become the num2 pop out till the comming element is smaller than the peek()
the last smallest element will become the num2 .if comming element is smaller than the num2 means it is valid  
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
