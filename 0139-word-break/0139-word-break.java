class Solution {
    HashMap<String, Integer> map;
    Boolean [] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        dp = new Boolean [s.length()];
        for (String str : wordDict) {
            map.put(str, 1);
        }
        return dfs(s, 0, 0);
    }

    boolean dfs(String s, int prev, int i) {
        if (i == s.length() - 1) {
            if (map.containsKey(s.substring(prev, i + 1))) {
                return dp[prev] = true;
            }
            return dp[prev] = false;
        }
        if (dp[prev] != null) {
            return dp[prev];
        }
        boolean take = false;
        boolean nottake = false;
        if (map.containsKey(s.substring(prev, i + 1))) {
            take = dfs(s, i + 1, i + 1);
            nottake = dfs(s, prev, i + 1);
        } else {
            nottake = dfs(s, prev, i + 1);
        }
        return dp[prev] = take || nottake;
    }
}