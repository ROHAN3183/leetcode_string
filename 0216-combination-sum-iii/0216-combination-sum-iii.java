class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(1, n, k, list);

        return result;
    }

    void dfs(int idx, int target, int k, List<Integer> list) {

        if (list.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = idx; i <= 9; i++) {

            if (i > target) {
                break;
            }
            list.add(i);

            dfs(i + 1, target - i, k, list);

            list.remove(list.size() - 1);
        }
    }
}
