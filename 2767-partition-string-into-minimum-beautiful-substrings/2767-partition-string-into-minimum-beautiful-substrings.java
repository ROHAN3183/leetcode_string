class Solution {
    public int minimumBeautifulSubstrings(String s) {
        int result = dfs(s, 0);
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    int dfs(String s, int start) {

        if (start == s.length()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i < s.length(); i++) {
            if (isValid(s, start, i)) {
                int ans = dfs(s, i + 1);
                if (ans != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + ans);
                }
            }
        }
        return min;
    }

    boolean isValid(String s, int i, int j) {
        if (j >= s.length()) {
            return false;
        }
        if (s.charAt(i) == '0') {
            return false;
        }
        int count = 0;
        int p = 0;
        for (int k = j; k >= i; k--) {
            if (s.charAt(k) == '1') {
                count += (int) Math.pow(2, p);

            }
            p++;
        }
        int temp = count;
        while (temp > 1) {
            if (temp % 5 != 0) {
                return false;
            }
            temp /= 5;
        }
        return true;
    }
}