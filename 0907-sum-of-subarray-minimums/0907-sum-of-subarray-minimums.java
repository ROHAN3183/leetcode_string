class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int ans=0;
        int MOD=1_000_000_007;
        int [] NSL=nearestToLeft(arr,n);
        int [] NSR=nearestToRight(arr,n);
        for(int i=0;i<n;i++){
            int left=i-NSL[i];
            int right=NSR[i]-i;
            ans = (int) ((ans + ((long) arr[i] * left % MOD * right % MOD) % MOD) % MOD);
        }
        return ans;
    }
    private int []nearestToLeft(int []arr,int n){
        Stack<Integer> stack=new Stack<>();
        int [] NSL=new int [n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                NSL[i]=-1;
            }
            else{
                NSL[i]=stack.peek();
            }
            stack.push(i);
        }
        return NSL;
    }

        private int []nearestToRight(int []arr,int n){
        Stack<Integer> stack=new Stack<>();
        int [] NSR=new int [n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                NSR[i]=n;
            }
            else{
                NSR[i]=stack.peek();
            }
            stack.push(i);
        }
        return NSR;
    }
}