class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        return dfs(words, "", 0);
    }

    int dfs(String[] words, String prev, int idx) {
        if (idx >= words.length) {
            return 0;
        }
        String key = prev + '#' + idx;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int take = 0;
        if (prev.isEmpty() || isValid(words[idx], prev)) {
            take = 1 + dfs(words, words[idx], idx + 1);
        }
        int nottake = dfs(words, prev, idx + 1);
        int ans = Math.max(take, nottake);
        map.put(key, ans);
        return ans;
    }

    boolean isValid(String current, String prev) {
        if ((current.length() - prev.length()) != 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        boolean skipped = false;
        while (i < prev.length() && j < current.length()) {
            if (current.charAt(j) == prev.charAt(i)) {
                i++;
            } else {
                if (skipped) {
                    return false;
                }
                skipped = true;
            }
            j++;

        }
        return true;
    }
}