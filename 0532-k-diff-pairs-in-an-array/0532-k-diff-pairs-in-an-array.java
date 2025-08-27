class Solution {
    HashMap<String,Integer>map;
    public int findPairs(int[] nums, int k) {
        map=new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            binarySearch(nums,k ,nums[i],i+1,n-1,map);
        }
        return map.size();

    }

    void binarySearch(int [] nums , int  k, int first, int i ,int n , HashMap<String,Integer>map){
        int low = i;
        int high= n;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(Math.abs(first-nums[mid])==k){
                String str1=Integer.toString(first);
                String str2=Integer.toString(nums[mid]);
                String str = str1+str2;
                map.put(str,map.getOrDefault(str,0)+1);
                break;
            }
            else if( Math.abs(first-nums[mid])>k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
    }
}