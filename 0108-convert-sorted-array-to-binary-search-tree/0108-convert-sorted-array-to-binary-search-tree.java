/*logic of the code
Recursively find the mid of the array element.
then send it as the mid +1 and mid -1 in the left and the right call of the recursion.
*/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        return dfs(nums, 0, nums.length - 1);
    }

    TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;

        }
        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = dfs(nums, start, mid - 1);

        root.right = dfs(nums, mid + 1, end);

        return root;
    }
}
