class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int i=0;
        int jump=0;
        int idx=0;
        while(i<n-1){
            int j=i+1;
            int maxi=Integer.MIN_VALUE;
            boolean flag=true;
            int count=0;
            while(j<n && count < nums[i]){
                if(maxi<=nums[j]){
                    maxi=nums[j];
                    idx=j;
                }

                count++;
                j++;
            }
            if (idx == i) return -1;
            jump++;
            i=idx;
        }
        return jump;
    }
}