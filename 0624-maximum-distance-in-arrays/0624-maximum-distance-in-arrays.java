class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int maximum=Integer.MIN_VALUE;
        int minimum=Integer.MAX_VALUE;
        int maxIdx=0;
        int minIdx=0;

        for(int i=0;i<n;i++){ //find the maximum 
           int largest = arrays.get(i).get(arrays.get(i).size()-1);
           if(maximum<largest){
                maximum=Math.max(maximum,largest);
                maxIdx=i;
           }
           
        }

        for(int i=0;i<arrays.size();i++){// find the minimum
            if(i==maxIdx)continue;
            int smallest=arrays.get(i).get(0);
            if(minimum>smallest){
                minimum=Math.min(minimum,smallest);
            }

        }
        return maximum-minimum;

    }
}