class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int max=0;

        for(int num:nums){
            set.add(num);
        }

        for(int num:set){
            if(!set.contains(num-1)){
                int count=0;
                int val=num;

                while(set.contains(val)){
                    count++;
                    val++;
                }

                max=Math.max(max,count);
            }
        }

        return max;
    }
}