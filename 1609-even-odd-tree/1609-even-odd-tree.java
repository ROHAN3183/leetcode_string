class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (level % 2 != 0) {//odd
                for (int i = 0; i < list.size(); i++) {
                    if (i == 0) {
                        if (list.get(i) % 2 != 0) {
                            return false;
                        }

                    }
                    if (i > 0 && (list.get(i) % 2 != 0 || list.get(i - 1) <= list.get(i))) {
                        return false;
                    }

                }
            } else {//even
                for (int i = 0; i < list.size(); i++) {
                    if (i == 0) {
                        if (list.get(i) % 2 == 0 ) {
                            return false;
                        }

                    }
                    if (i > 0 && (list.get(i) % 2 == 0 || list.get(i - 1) >= list.get(i))) {
                        return false;
                    }

                }

            }
            level++;
        }
        return true;

    }
}