class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] result=new int [nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int target=nums1[i];
            int val=foundtarget(nums2,target);
            if(val!=-1){
                result[i]=isvalid(nums2,target,val);
            }
            else{
                result[i]=-1;
            }

        }
        return result;
    }
    int  foundtarget(int [] nums2,int target){
        for(int i=0;i<nums2.length;i++){
            if(nums2[i]==target){
                return i;
            }
        }
        return -1;
    }
    int isvalid(int [] nums2,int target,int idx){
        for(int i=idx;i<nums2.length;i++){
            if(nums2[i]>target){
                return nums2[i];
            }
        }
        return -1;
    }
}