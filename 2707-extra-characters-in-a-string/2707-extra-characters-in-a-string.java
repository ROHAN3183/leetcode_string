class Solution {
    HashMap<String, Integer> map;
    int[] dp;

    public int minExtraChar(String s, String[] dictionary) {
        map = new HashMap<>();
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        for (String str : dictionary) {
            map.put(str, 1);
        }
        return dfs(s, 0);

    }

    int dfs(String s, int idx) {

        if (idx >= s.length()) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int min = s.length();

        for (int i = idx; i < s.length(); i++) {
            int left = 0;
            if (!map.containsKey(s.substring(idx, i + 1))) {
                left = i - idx + 1;
            }

            int right = dfs(s, i + 1);
            int total = left + right;

            min = Math.min(min, total);
        }

        return dp[idx] = min;
    }
}