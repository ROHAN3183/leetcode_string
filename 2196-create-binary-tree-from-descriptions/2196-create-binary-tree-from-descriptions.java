class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < descriptions.length; i++) {

            int parentVal = descriptions[i][0];
            int childVal = descriptions[i][1];
            int isLeft = descriptions[i][2];

            TreeNode parent = map.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode child = map.getOrDefault(childVal, new TreeNode(childVal));

            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            list.add(childVal);

            map.put(parentVal, parent);
            map.put(childVal, child);
        }
        for (int i = 0; i < descriptions.length; i++) {
            int parent = descriptions[i][0];
            if (!list.contains(parent)) {
                return map.get(parent);
            }
        }
        return null;

    }

}