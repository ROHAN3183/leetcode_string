class Solution {
   private static final int M= (int)1e9+7;
    public int countGoodNumbers(long n) {
        long even_power=(n+1)/2;
        long odd_power=n/2;
        long result=(find_Exponential(5,even_power)*find_Exponential(4,odd_power))%M;
        return (int)result;
    }
    private long find_Exponential(long a,long b){
        long result=1;
        if(b==0){
            return 1;
        }
        while(b>0){
            if(b%2==1){
                result=a*result;
                b=b-1;
            }
            else{
                b=b/2;
                a=a*a;

            }
        }
        return result%M;
    }
}