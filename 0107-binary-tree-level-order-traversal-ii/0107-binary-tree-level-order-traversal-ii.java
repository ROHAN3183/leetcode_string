class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        Stack<List<Integer>> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null){
            return new ArrayList<>();
        }    
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);

                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            stack.push(list);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());

        }
        return result;

    }
}