class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int max_area=Integer.MIN_VALUE;
        int[] NSR=nearestSmallerToRight(heights,n);
        int[] NSL=nearestSmallerToLeft(heights,n);
        for(int i=0;i<n;i++){
           int width=NSR[i]-NSL[i]-1;
           int area=width*heights[i];
           max_area=Math.max(area,max_area);
        }
        return max_area;
    }
    private int[] nearestSmallerToLeft(int []heights,int n){
        Stack<Integer> stack=new Stack<>();
        int [] NSL= new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
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
    private int[] nearestSmallerToRight(int []heights,int n){
        Stack<Integer> stack=new Stack<>();
        int [] NSR= new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() &&  heights[stack.peek()]>=heights[i]){
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