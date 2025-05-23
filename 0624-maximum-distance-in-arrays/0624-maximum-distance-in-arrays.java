class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n=arrays.size();
        int minVal=arrays.get(0).get(0);
        int maxVal=arrays.get(0).get(arrays.get(0).size()-1);
        int maxDistance=0;

        for(int i=1;i<n;i++){
            int currentmin=arrays.get(i).get(0);
            int currentmax=arrays.get(i).get(arrays.get(i).size()-1);

            maxDistance=Math.max(maxDistance,Math.abs(currentmin-maxVal));
            maxDistance=Math.max(maxDistance,Math.abs(currentmax-minVal));

            if(currentmin<minVal){
                minVal=currentmin;
            }
            if(currentmax>maxVal){
                maxVal=currentmax;
            }
        }
        return maxDistance;
    }
}