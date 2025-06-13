#logic of the code-> Always pass the extra coin to the parent that is "leftmoves + rightmoves + root.val - 1" .
    
class Solution {
    int moves;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;

    }

    int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftmoves = dfs(root.left);

        int rightmoves = dfs(root.right);

        moves += Math.abs(leftmoves) + Math.abs(rightmoves);

        return leftmoves + rightmoves + root.val - 1;
    }
}
