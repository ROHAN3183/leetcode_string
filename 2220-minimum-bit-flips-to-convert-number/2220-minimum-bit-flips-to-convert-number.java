class Solution {
    public int minBitFlips(int start, int goal) { // XOR GATE after that AND GATE
        int res=start^goal;
        int count=0;
        for(int i=0;i<31;i++){
            if((res & (1<<i))!=0){
                count++;
            }
        }
        return count;
    }
}
