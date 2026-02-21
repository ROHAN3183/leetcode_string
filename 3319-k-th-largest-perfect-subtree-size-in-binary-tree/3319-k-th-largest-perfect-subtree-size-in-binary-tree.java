class Solution {
    class info {
        boolean isvalid;
        int count;

        info(boolean isvalid, int count) {
            this.isvalid = isvalid;
            this.count = count;
        }
    }

    List<Integer> list;

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root);
        Collections.sort(list, Collections.reverseOrder());
        if (list.size() < k) {
            return -1;
        }
        return list.get(k - 1);
    }

    info dfs(TreeNode root) {
        if (root == null) {
            return new info(true, 0);
        }
        info left = dfs(root.left);
        info right = dfs(root.right);

        if (left.isvalid && right.isvalid && left.count == right.count) {
            list.add(left.count + right.count + 1);
            return new info(true, left.count + right.count + 1);
        }
        return new info(false, left.count + right.count + 1);
    }
}