class Solution {

    class Pair {
        TreeNode node;
        int value;

        Pair(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Pair> list = new ArrayList<>();
        Storingdfs(root, list);
        return creationdfs(list, 0, list.size() - 1);

    }

    void Storingdfs(TreeNode root, List<Pair> list) {
        if (root == null) {
            return;
        }
        Storingdfs(root.left, list);
        list.add(new Pair(root, root.val));
        Storingdfs(root.right, list);
    }

    TreeNode creationdfs(List<Pair> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;

        TreeNode newnode = list.get(mid).node;

        newnode.left = creationdfs(list, start, mid - 1);
        newnode.right = creationdfs(list, mid + 1, end);

        return newnode;
    }

}