class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int idx=0;
        int []result=new int[n];
        Arrays.fill(result,-1);
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(nums2[i],i);
        }
        for(int i=0;i<n;i++){
            int element=nums1[i];
            if(map.containsKey(element)){
                idx=map.get(element);
            }
            for(int j=idx+1;j<m;j++){
                if(nums2[j]>element){
                    result[i]=nums2[j];
                    break;
                }
            }
        }
        return result;
    }
}