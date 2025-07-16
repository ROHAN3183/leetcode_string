class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        int n=matrix.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<matrix[0].length;j++){
                maxHeap.add(matrix[i][j]);
            }
        }

        while(maxHeap.size()>k){
            maxHeap.poll();
        }

        return maxHeap.peek();
        
    }
}