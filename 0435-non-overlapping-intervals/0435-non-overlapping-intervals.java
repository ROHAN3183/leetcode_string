class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int currentEnd=intervals[0][1];
        int count=0;

        for(int i=1;i<n;i++){
            int nextStart=intervals[i][0];
            if(currentEnd > nextStart){
                count++;
                currentEnd=intervals[i][1];
                nextStart=intervals[i][0];

            }
        }
        return count;
    }
}