logic : find the min and the max where there is downfall in the graph.
    
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=1;i<n;i++){ 
            if(nums[i]<nums[i-1]){
                min=Math.min(min,nums[i]);
                max=Math.max(max,nums[i-1]);
            }
        }
        if(min==Integer.MAX_VALUE && max==Integer.MIN_VALUE){
            return 0;
        }
        int leftIndex=-1;
        int rightIndex=-1;
        int i=0;
        int j=n-1;
        boolean flag1=false;
        boolean flag2=false;
        while(i<n && j>=0){
            if( i<n && nums[i]>min && flag1==false){
                leftIndex=i;
                flag1=true;

            }

            if(j>=0 && nums[j]<max && flag2==false){
                rightIndex=j;
                flag2=true;
            }

            if(flag1 && flag2){
                break;
            }
            if(!flag1)i++;
            if(!flag2)j--;
        }
        return rightIndex-leftIndex+1;

        
    }
}
