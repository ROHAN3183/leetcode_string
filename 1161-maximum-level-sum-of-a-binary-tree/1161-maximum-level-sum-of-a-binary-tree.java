class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int max = -(int) Math.pow(10, 5);
        int level = 1;
        int index = 1;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum = sum + node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            if (max < sum) {
                max = sum;
                level = index;
            }
            index++;

        }
        return level;

    }
}
***************************************************DFS**************************************************************************

class Solution {
    public int maxLevelSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int result = 1;
        traverse(root, 1, map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int key = entry.getKey();
            int value = entry.getValue();
            if (max < value) {
                max = value;
                result = key;
            }

        }
        return result;

    }

    void traverse(TreeNode root, int level, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        if (map.containsKey(level)) {
            int oldValue = map.get(level);
            map.put(level, oldValue + root.val);
        } else {
            map.put(level, root.val);
        }

        traverse(root.left, level + 1, map);
        traverse(root.right, level + 1, map);
    }
}
