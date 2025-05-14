class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int needs[]=new int [n];
        for(int i=0;i<n;i++){
            needs[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(needs);
        int count=0;
        for(int i=0;i<n;i++){
            if(needs[i]>=0 && (additionalRocks >= needs[i])){
                additionalRocks=additionalRocks-needs[i];
                count++;

            }
        }
        return count;
        
    }
}