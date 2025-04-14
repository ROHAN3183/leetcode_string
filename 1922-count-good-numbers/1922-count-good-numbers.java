class Solution {
   private static final int M= (int)1e9+7;
    public int countGoodNumbers(long n) {
        long even_power=(n+1)/2;
        long odd_power=n/2;
        long result=(find_Exponential(5,even_power)*find_Exponential(4,odd_power))%M;
        return (int)result;
    }
    private long find_Exponential(long a,long b){
        if(b==0){
            return 1;
        }
        long half=find_Exponential(a,b/2);
        long result=(half*half)%M;
        if(b%2==1){
            result=(result*a)%M;
        }
        return result;
    }
}