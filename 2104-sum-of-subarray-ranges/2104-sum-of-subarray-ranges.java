#Logic of the code
1) first find the nextgreaterelementfrom the right second nextgreaterelementfrom the left third smallest to left and also
    find the smallest right.
    
class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long ans=0;
        int [] Right_max=nextGreaterToRight(nums,n);
        int [] Left_max=nextGreaterToleft(nums,n);
        int [] Right_smallest=nearestToRightSmallest(nums,n);
        int [] Left_smallest=nearestToLeftSmallest(nums,n);
        for(int i=0;i<n;i++){
            long max=(long) nums[i]*(Right_max[i]-i)*(i-Left_max[i]);
            long min=(long) nums[i]*(Right_smallest[i]-i)*(i-Left_smallest[i]);
            ans=ans+(max-min);
        }
        return ans;
    }
    private int []nextGreaterToRight(int [] nums,int n){
        Stack<Integer> stack=new Stack<>();
        int []NGE=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                NGE[i]=n;
            }
            else{
                NGE[i]=stack.peek();
            }
            stack.push(i);
        }
        return NGE;
    }
        private int []nextGreaterToleft(int [] nums,int n){
        Stack<Integer> stack=new Stack<>();
        int []PGE=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                PGE[i]=-1;
            }
            else{
                PGE[i]=stack.peek();
            }
            stack.push(i);
        }
        return PGE;
    }
    private int[]nearestToLeftSmallest(int[] nums,int n){
        Stack<Integer> stack=new Stack<>();
        int PSE[]=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                PSE[i]=-1;
            }
            else{
                PSE[i]=stack.peek();
            }
            stack.push(i);
        }
        return PSE;
    }
        private int[]nearestToRightSmallest(int[] nums,int n){
        Stack<Integer> stack=new Stack<>();
        int NSE[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                NSE[i]=n;
            }
            else{
                NSE[i]=stack.peek();
            }
            stack.push(i);
        }
        return NSE;
    }
}
