class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(1, n, k, list);
        return result;
    }

    void dfs(int idx, int target, int k, List<Integer> list) {
        if (idx == 10) {
            if (list.size() == k && target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(idx);
        dfs(idx + 1, target - idx, k, list);
        list.remove(list.size() - 1);

        dfs(idx + 1, target, k, list);
        return;
    }
}