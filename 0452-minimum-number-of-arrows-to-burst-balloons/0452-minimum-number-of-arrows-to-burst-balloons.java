class Solution {
    public int findMinArrowShots(int[][] points) {

        int n=points.length;

        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));

        int currentStart=points[0][0];
        int currentEnd=points[0][1];

        int count=1;


        for(int i=1;i<n;i++){

            int nextStart=points[i][0];
            int nextEnd=points[i][1];

            if(currentEnd < nextStart){ // non overlapping 
                count++;
                currentStart=nextStart;
                currentEnd=nextEnd;
            }
            else if(currentStart <= nextEnd){// overlapping
                
                currentStart=Math.max(currentStart,nextStart);
                currentEnd=Math.min(currentEnd,nextEnd);
            }
        }
        return count;
        
    }
}