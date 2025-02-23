class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int []result=new int[n];
        int [] NGR=nextGreaterElement(temperatures,n);
        for(int i=0;i<n;i++){
            if(NGR[i]==-1){
                result[i]=0;
            }
            else{
                result[i]=NGR[i]-i;
            }
        }
        return result;
        
    }
    int []nextGreaterElement(int []temperatures,int n){
        Stack<Integer> stack=new Stack<>();
        int []NGR=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                NGR[i]=-1;
            }
            else{
                NGR[i]=stack.peek();
            }
            stack.push(i);
        }
        return NGR;
    }
}