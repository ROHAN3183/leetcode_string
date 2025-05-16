class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int currentStart=intervals[0][0];
        int currentEnd=intervals[0][1];
        List<int[]>list=new ArrayList<>();
        boolean flag=true;

        for(int i=1;i<n;i++){

            int nextStart=intervals[i][0];
            int nextEnd=intervals[i][1];

            if(currentEnd>=newInterval[0] && flag==true){
                currentEnd=Math.max(currentEnd,newInterval[1]);
                flag=false;
            }
            else if(currentEnd>=nextStart){
                currentEnd=Math.max(currentEnd,nextEnd);
            }
            else{
                list.add(new int[]{currentStart,currentEnd});
                currentStart=nextStart;
                currentEnd=nextEnd;
            }

        }
        list.add(new int[]{currentStart,currentEnd});
        return list.toArray(new int[list.size()][]);
    }
}