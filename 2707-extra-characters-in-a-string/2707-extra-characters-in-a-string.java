class Solution {
    HashMap<String, Integer> map;

    public int minExtraChar(String s, String[] dictionary) {
        map = new HashMap<>();
        for (String str : dictionary) {
            map.put(str, 1);
        }
        return dfs(s, 0);

    }

    int dfs(String s, int idx) {

        if (idx >= s.length()) {
            return 0;
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

        return min;
    }
}