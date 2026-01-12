class Solution {
    public int maxLength(List<String> arr) {
        int[] used = new int[26];
        return dfs(arr, used, 0);
    }

    boolean isValid(int[] used, String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (used[ch - 'a'] >= 1) {
                return false;
            }
        }
        return true;
    }

    void add(int[] used, String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            used[ch - 'a']++;
        }
    }

    void remove(int[] used, String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            used[ch - 'a']--;
        }
    }

    int dfs(List<String> arr, int[] used, int idx) {
        if (idx >= arr.size()) {
            return 0;
        }
        int max = 0;
        for (int i = idx; i < arr.size(); i++) {
            String s = arr.get(i);
            if (isValid(used, s)) {
                add(used, s);
                max = Math.max(max, s.length() + dfs(arr, used, i + 1));
                remove(used, s);

            }

        }
        return max;
    }
}