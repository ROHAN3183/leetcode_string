class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        int count=0;

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        int currentStart=intervals[0][0];
        int currentEnd=intervals[0][1];

        for(int i=1;i<n;i++){
            int nextStart=intervals[i][0];
            int nextEnd=intervals[i][1];

            if(currentEnd <= nextStart){// non overlapping
                currentStart=nextStart;
                currentEnd=nextEnd;
            }
            else if(currentStart <= nextEnd){// overlapping
                currentStart=Math.max(currentStart,nextStart);
                currentEnd=Math.min(currentEnd,nextEnd);
                count++;

            }
        }
        return count;
    }
}