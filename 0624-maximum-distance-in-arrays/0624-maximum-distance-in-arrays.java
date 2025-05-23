class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int maximum=Integer.MIN_VALUE;
        int minimum=Integer.MAX_VALUE;
        int maxIdx=0;
        int minIdx=0;
        int result=0;

        for(int i=0;i<n;i++){  
           int largest = arrays.get(i).get(arrays.get(i).size()-1); //find the maximum
           if(maximum<largest){
                maximum=Math.max(maximum,largest);
                maxIdx=i;
           }
            int smallest=arrays.get(i).get(0); //find the smallest
            if(minimum>smallest){
                minimum=Math.min(minimum,smallest);
                minIdx=i;
            }
            if(minIdx!=maxIdx){
                result=Math.max(Math.abs(maximum-minimum),result);
            }
           
        }
        return result;

    }
}