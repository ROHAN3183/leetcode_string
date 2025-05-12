class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

       int n=nums.length;

       int [] result=new int [n-k+1];

       Deque<Integer>Dq=new ArrayDeque<>();

       int j=0,idx=0;

       while(j<n){

        while(!Dq.isEmpty() && Dq.peekFirst()<j-k+1){
            Dq.pollFirst();
        }

        while(!Dq.isEmpty() && nums[Dq.peekLast()]<nums[j]){
            Dq.pollLast();
        }

        Dq.addLast(j);
        if(j>=k-1){
            result[idx++]=nums[Dq.peekFirst()];
        }

        j++;

       }
       return result;
        
    }
}