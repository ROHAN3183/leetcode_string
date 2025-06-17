class Solution {
    public int[][] generateMatrix(int n) {
        int [][]ans=new int[n][n];
        int [][]result=new int[n][n];
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;
        int count=1;
        while(left<=right&& top<=bottom){
            for(int i=left;i<=right;i++){
                result[top][i]=count++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                result[i][right]=count++;
            }
            right--;
            for(int i=right;i>=left;i--){
                result[bottom][i]=count++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                result[i][left]=count++;
            }
            left++;
        }
        for(int i=0;i<result.length;i++){
           for(int j=0;j<result.length;j++){
            ans[i][j]=result[i][j];
           }
        }
        return ans;
        
        
    }
}