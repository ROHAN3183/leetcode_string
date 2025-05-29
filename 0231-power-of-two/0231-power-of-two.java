class Solution {
    public boolean isPowerOfTwo(int n) {
        return power(n,0);

        
    }
    boolean power(int n,int i){
        double pow=Math.pow(2,i);
        if(pow==n){
            return true;
        }
        if(pow>n){
            return false;
        }
        return power(n,i+1);
    }
}