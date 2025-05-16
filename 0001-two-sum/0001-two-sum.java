class Solution {
    public int[] twoSum(int[] nums, int target) {

        int n=nums.length;

        HashMap<Integer,Integer>map=new HashMap<>();
        int[] result=new int[2];

        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }

        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int firstValue=entry.getKey();
            int index1=entry.getValue();
            int secondValue=Math.abs(target-firstValue);


            if(map.containsKey(secondValue)){
                int index2=map.get(secondValue);
                return new int[]{index1,index2};
            }
        }
        return result;
        
    }
}