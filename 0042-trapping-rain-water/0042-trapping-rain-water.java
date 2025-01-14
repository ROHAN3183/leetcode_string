class Solution {
    public int trap(int[] height) { // mantain left_largest and right_largest array for difference between them
        int n=height.length;
        int [] left_largest =new int[n];
        int [] right_largest=new int[n];
        int count=0;
        left_largest[0]=height[0];
        for(int i=1;i<n;i++){
            left_largest[i]=Math.max(height[i],left_largest[i-1]);
        }
        right_largest[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            right_largest[i]=Math.max(height[i],right_largest[i+1]);
        }
        for(int j=0;j<n;j++){
           count+= Math.min(left_largest[j],right_largest[j])-height[j];
        }
        return count;
    }
}
