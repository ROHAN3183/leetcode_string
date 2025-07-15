/*logic of the code -> track the size of the map once if got the valid subarray it means upcomming will be also valid only 
so now move forward the i pointer so that new subarray can we found.*/
class Solution {
    public int countCompleteSubarrays(int[] nums) {

        Set<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int count=0;

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int i = 0;
        int j = 0;
        int size = set.size();

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            if (map.size() == size) {
                count = count + 1 + (n - 1 - j);
                while (i<n && map.size() >= size) {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                    if (map.get(nums[i]) <= 0) {
                        map.remove(nums[i]);
                    }
                    i++;
                }
            }
            j++;

        }
        return count;

    }
}
