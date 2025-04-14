class Solution {
    public double myPow(double x, int n) {
        double ans=1;
        if(n==Integer.MIN_VALUE){
            x=1/x;
            n=Integer.MAX_VALUE;
        }
        if(n<0){
            x=1/x;
            n=-n;
        }
        while(n>0){
            if(n%2==1){
                ans=ans*x;
            }
            x=x*x;
            n=n/2;
        }
        if(n<0){
            return -ans;
        }
        return ans;
    }
}