class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int maxfreq = 0;
        for (int freq : map.values()) {
            maxfreq = Math.max(maxfreq, freq);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxfreq) {
                result.add(entry.getKey());
            }
        }
        int size = result.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    int dfs(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, map);
        int right = dfs(root.right, map);
        int totalSubtreeSum = left + right + root.val;
        map.put(totalSubtreeSum, map.getOrDefault(totalSubtreeSum, 0) + 1);
        
        return totalSubtreeSum;
    }
}