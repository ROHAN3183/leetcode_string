class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        permutation(nums, list, result, map);
        return result;
    }

    void permutation(int[] nums,List<Integer> list,List<List<Integer>> result,HashMap<Integer,Integer> map) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }


        for (Map.Entry<Integer,Integer>entry:map.entrySet()) {

            int key=entry.getKey();
            int value=entry.getValue();
            if (value == 0 ) continue;


            list.add(key);
            map.put(key, map.getOrDefault(key,0)- 1);

            permutation(nums, list, result, map);

            list.remove(list.size() - 1);
            map.put(key, map.getOrDefault(key,0) + 1);
        }
    }
}
