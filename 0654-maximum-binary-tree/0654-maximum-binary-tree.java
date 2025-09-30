class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    TreeNode dfs(int[] nums, int low, int high) {

        if (low > high) {
            return null;
        }

        int max = -1;
        int idx = -1;

        for (int i = low; i <= high; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);

        root.left = dfs(nums, low, idx - 1);
        root.right = dfs(nums, idx + 1, high);

        return root;
    }
}