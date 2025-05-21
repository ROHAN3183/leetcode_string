class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int count=0;
        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<n;i++){ //counting frequency
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){

            int key=entry.getKey();
            int value=entry.getValue();
            if(value==1){
                return -1;
            }
            else{
                
                count=count+ (int)Math.ceil((double)value/3);
            }

        }

        return count;

    }
}