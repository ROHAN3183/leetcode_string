class Solution {
    public int minimumArea(int[][] grid) {
        int n2=grid[0].length;
        int n1=grid.length;

        int minWidth=Integer.MAX_VALUE;
        int maxWidth=Integer.MIN_VALUE;
        int minLength=Integer.MAX_VALUE;
        int maxLength=Integer.MIN_VALUE;

        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(grid[i][j]==1){
                    minWidth=Math.min(minWidth,j);
                    maxWidth=Math.max(maxWidth,j);
                }
            }
        }
        for(int i=0;i<n2;i++){
            for(int j=0;j<n1;j++){
                if(grid[j][i]==1){
                    minLength=Math.min(minLength,j);
                    maxLength=Math.max(maxLength,j);
                }
            }
        }
        int width=maxWidth-minWidth+1;
        int length=maxLength-minLength+1;
        return length*width;
    }
}