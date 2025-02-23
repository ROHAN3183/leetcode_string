logic of the code
    
1) suppose a=stack.peek() whereas b=coming element that is asteroids[i] if sum of a+b is negative means a is smaller means 
    stack.peek() will get distorey till the that sum don't become the positive.
2) if sum is positive means b is smaller it means comming element is smaller so that it will destorey means no need to push it
    into the stack. if conditoin is neutural means both will get destorey so no need to push.
    
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
