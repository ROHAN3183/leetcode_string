class Solution {
    public int numTrees(int n) {
        return dfs(1, n);
    }

    int dfs(int low, int high) {
        if (low >= high) {
            return 1;
        }
        int total = 0;
        for (int i = low; i <= high; i++) {
            int left = dfs(low, i - 1);
            int right = dfs(i + 1, high);
            total += left * right;
        }
        return total;
    }
}