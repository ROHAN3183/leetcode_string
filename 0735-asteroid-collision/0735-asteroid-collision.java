class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            boolean flag=true;
            while(!stack.isEmpty()&&flag==true &&stack.peek()>0 &&asteroids[i]<0 ){
              int  sum=stack.peek()+asteroids[i];
                if(sum<0){
                    stack.pop();
                }
                else if(sum>0){
                    flag=false;
                }
                else{
                    stack.pop();
                    flag=false;
                }
            }
            if(flag){
                stack.push(asteroids[i]);
            }
        }
        int []arr=new int[stack.size()];
        for(int i= stack.size()-1;i>=0;i--){
            arr[i]=stack.pop();
        }
        return arr;
    }
}