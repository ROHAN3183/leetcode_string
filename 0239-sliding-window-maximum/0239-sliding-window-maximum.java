class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int n=nums.length;
       int [] result=new int [n-k+1];
       Deque<Integer>Dq=new ArrayDeque<>();
       int idx=0;
       for(int j=0;j<n;j++){

        if(!Dq.isEmpty() && Dq.peekFirst()<j-k+1){ //remove the extra size element
            Dq.pollFirst();
        }
        while(!Dq.isEmpty() && nums[Dq.peekLast()]<nums[j]){ //remove the smallar element from the Dequeue
            Dq.pollLast();
        }
        Dq.addLast(j);
        if(j>=k-1){
            result[idx++]=nums[Dq.peekFirst()];
        }

       }
       return result;
        
    }
}