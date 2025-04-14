class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int row=points.length;
        PriorityQueue<int[]>maxHeap=new PriorityQueue<>((a,b)->{
        int distanceA=a[0]*a[0]+a[1]*a[1];
        int distanceB=b[0]*b[0]+b[1]*b[1];
        return distanceB-distanceA;
        });

        for(int i=0;i<row;i++){
            maxHeap.add(points[i]);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int result[][]=new int[k][2];
        int i=0;
        while(!maxHeap.isEmpty()){
            result[i++]=maxHeap.poll();
        }
        return result;
    }
}