class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        return power(n,0);
        
    }
    boolean power(int n,int i){
        double pow=Math.pow(3,i);
        if(pow==n){
            return true;
        }
        if(pow > n){
            return false;
        }
        return power(n,i+1);
    }
}