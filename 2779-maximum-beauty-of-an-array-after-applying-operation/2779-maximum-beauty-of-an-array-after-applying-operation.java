class Solution {
    public int maximumBeauty(int[] nums, int k) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(Arrays.asList(nums[i] - k, nums[i] + k));
        }
        Collections.sort(list, (a, b) -> Integer.compare(a.get(0), b.get(0)));
        int max = 1;
        int count = 1;

        for (int i = 0; i < list.size(); i++) {
            int prevStart=list.get(i).get(0);
            int prevEnd=list.get(i).get(1);
            count =1;
            for(int j=i+1 ;j<list.size();j++){
                int currStart =list.get(j).get(0);
                int currEnd =list.get(j).get(1);
                if(prevEnd >=currStart){
                    count++;
                    prevStart=Math.max(currStart ,prevStart);
                    prevEnd=Math.min(currEnd,prevEnd);
                }
                else{
                    break;
                }
            }
            max=Math.max(max,count);
        }
        return max;
    }
}