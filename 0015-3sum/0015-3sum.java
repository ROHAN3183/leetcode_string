class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int right = nums[low] + nums[high];
                if (left + right == 0) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[low], nums[high])));
                    low++;
                    high--;
                    while(low<high && nums[low]==nums[low-1]){
                        low++;
                    }
                    while(low<high && nums[high]==nums[high+1]){
                        high--;
                    }
                } else if (left + right < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return list;
    }
}