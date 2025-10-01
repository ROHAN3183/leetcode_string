class Solution {
    int count;

    public int countPairs(TreeNode root, int distance) {
        count = 0;
        dfs(root, distance);
        return count;
    }

    List<Integer> dfs(TreeNode root, int distance) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            List<Integer> leaf = new ArrayList<>();
            leaf.add(1);
            return leaf;
        }
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        leftList = dfs(root.left, distance);
        rightList = dfs(root.right, distance);

        for (int i = 0; i < leftList.size(); i++) {
            for (int j = 0; j < rightList.size(); j++) {
                if (leftList.get(i) + rightList.get(j) <= distance) {
                    count++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < leftList.size(); i++) {
            result.add(leftList.get(i) + 1);
        }
        for (int j = 0; j < rightList.size(); j++) {
            result.add(rightList.get(j) + 1);
        }

        return result;
    }
}