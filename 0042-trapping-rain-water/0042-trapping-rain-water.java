#1 optimized code space (2N)
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
#2 OPTIMIZED CODE space (1)
 
    Just use two pointer the for that if left is small it means that will be the deciding factor of the storing 
    because otherwise water will get flow .
    
    class Solution {
    public int trap(int[] height) { 
        int n=height.length;
        int left=0;
        int right=n-1;
        int ans=0;
        int left_max=0;
        int right_max=0;
        while(left<right){
             left_max=Math.max(left_max,height[left]);
             right_max=Math.max(right_max,height[right]);
            if(right_max >left_max){
                ans=ans+left_max-height[left];
                left++;
            }
            else{
                ans=ans+right_max-height[right];
                right--;
            }
        }
        return ans;
    }
}
