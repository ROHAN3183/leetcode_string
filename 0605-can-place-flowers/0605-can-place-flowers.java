class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size=flowerbed.length;
        int idx=0;

        for(int i=0;i<size;i++){
            if(flowerbed[i]==1){
                idx=i;
                break;
            }

        }
        boolean flag=false;
        if(idx%2==0){
            flag=true;
        }
        if(flag){
            for(int i=0;i<size;i++){
                if(i%2==0 && flowerbed[i]==0 && Math.abs(flowerbed[i]-flowerbed[i+1])==0){
                    n--;
                }
            }
        }
        else{
            for(int i=0;i<size;i++){
                if(i%2!=0 && flowerbed[i]==0 && Math.abs(flowerbed[i]-flowerbed[i+1])==0){
                    n--;
                }
            }
        }
        if(n==0){
            return true;
        }

        return false;
    }
}