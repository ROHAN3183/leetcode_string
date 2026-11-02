class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {

        result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, list, visited);

        return result;
    }

    void dfs(int[] nums, List<Integer> list, boolean[] visited) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
        return;
    }
}