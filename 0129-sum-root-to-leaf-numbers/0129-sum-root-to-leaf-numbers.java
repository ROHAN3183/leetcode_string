class Solution {
    public int sumNumbers(TreeNode root) {
        StringBuilder str = new StringBuilder();
        List<Integer> result = new ArrayList<>();
        traverse(root, str, result);
        int sum = 0;
        for (int i = 0; i < result.size(); i++) {
            sum = sum + result.get(i);
        }
        return sum;
    }

    void traverse(TreeNode root, StringBuilder str, List<Integer> result) {
        if (root == null) {
            return;
        }
        str.append(root.val);
        if (root.left == null && root.right == null) {
            String val = str.toString();
            int ans = Integer.parseInt(val);
            result.add(ans);
        }
        traverse(root.left, str, result);

        traverse(root.right, str, result);
        
        str.deleteCharAt(str.length() - 1);

    }
}