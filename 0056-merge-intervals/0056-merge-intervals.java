class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n==1){
            return intervals;
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list=new ArrayList<>();
        int [][]temp =new int[1][2];
        int currentStart=intervals[0][0];
        int currentEnd=intervals[0][1];

        for(int i=1;i<n;i++){
            int nextStart=intervals[i][0];
            int nextEnd=intervals[i][1];
            
            if(currentEnd >= nextStart){
                currentEnd=Math.max(currentEnd,nextEnd);
            }
            else{
                
                list.add(new int[]{currentStart,currentEnd});
                currentStart=nextStart;
                currentEnd=nextEnd;
            }
        }
        list.add(new int[]{currentStart,currentEnd});
        int[][] result=list.toArray(new int[list.size()][]);
        return result;
        
    }
}