class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]>list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int currentStart=intervals[0][0];
        int currentEnd=intervals[0][1];

        for(int i=1;i<n;i++){
            
            int nextStart=intervals[i][0];
            int nextEnd=intervals[i][1];

            if(currentEnd < nextStart){//non overlapping
                list.add(new int[]{currentStart,currentEnd});
                currentStart=nextStart;
                currentEnd=nextEnd;

            }
            else if(currentStart <= nextEnd){//overlapping condition

                currentStart=Math.min(currentStart,nextStart);
                currentEnd=Math.max(currentEnd,nextEnd);

            }

        }
        list.add(new int[]{currentStart,currentEnd});

        return list.toArray( new int[list.size()][]);
        
    }
}