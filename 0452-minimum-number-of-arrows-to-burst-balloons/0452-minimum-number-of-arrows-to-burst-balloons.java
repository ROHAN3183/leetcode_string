class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        if(n==1){
            return 1;
        }
        int arrow=1;
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int currentEnd=points[0][1];
        

        for(int i=1;i<n;i++){
            int nextStart=points[i][0];
            if(currentEnd < nextStart){
                arrow++;
                currentEnd=points[i][1];
                nextStart=points[i][0];
            }
        }
        return arrow;
    }
}