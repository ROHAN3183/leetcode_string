class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        traverse1(root1, leaf1);
        traverse2(root2, leaf2);
        if (leaf1.size() != leaf2.size()) {
            return false;
        }
        for (int i = 0; i < leaf1.size(); i++) {
            if (!leaf1.get(i).equals(leaf2.get(i))) {
                return false;
            }
        }
        return true;
    }

    void traverse1(TreeNode root1, List<Integer> leaf1) {
        if (root1 == null) {
            return;
        }
        if (root1.left == null && root1.right == null) {
            leaf1.add(root1.val); 
        }
        traverse1(root1.left, leaf1);
        traverse1(root1.right, leaf1);
    }

    void traverse2(TreeNode root2, List<Integer> leaf2) {
        if (root2 == null) {
            return;
        }
        if (root2.left == null && root2.right == null) {
            leaf2.add(root2.val); 
        }
        traverse2(root2.left, leaf2);
        traverse2(root2.right, leaf2);
    }
}
