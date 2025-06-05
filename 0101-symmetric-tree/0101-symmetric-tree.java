class Solution {
    public boolean isSymmetric(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<TreeNode> ans = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ans.add(node);

                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            result.add(ans);
        }

        for (int i = 0; i < result.size(); i++) {
            List<TreeNode> nums = result.get(i); // ✅ FIXED LINE
            if (!reversed(nums)) {               // ✅ FIXED FUNCTION CALL
                return false;
            }
        }

        return true;
    }

    boolean reversed(List<TreeNode> nums) { // ✅ FIXED FUNCTION SIGNATURE
        int i = 0;
        int j = nums.size() - 1;

        while (i < j) {
            TreeNode left = nums.get(i);
            TreeNode right = nums.get(j);

            if (left == null && right == null) {
                i++;
                j--;
                continue;
            }

            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
