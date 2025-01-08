class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        int j=0;
        while(j<n){
            if(map.containsKey(nums[j])){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }
            else{
                map.put(nums[j],1);
            }
            for(Integer key:map.keySet()){
                if(map.get(key)>n/2){
                    return key;
                }
            }
            j++;
        }
        return -1;
    }
}