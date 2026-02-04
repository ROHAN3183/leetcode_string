class Solution {
    int ans = 0;
    public int maxProduct(String s) {
        dfs(s, new StringBuilder(), new StringBuilder(), 0);
        return ans;
    }

    void dfs(String s, StringBuilder str1, StringBuilder str2, int idx) {
        if (idx >= s.length()) {
            if (isValid(str1) && isValid(str2)) {
                ans = Math.max(ans, str1.length() * str2.length());
            }
            return;
        }
        str1.append(s.charAt(idx));
        dfs(s, str1, str2, idx + 1);
        str1.deleteCharAt(str1.length() - 1);

        str2.append(s.charAt(idx));
        dfs(s, str1, str2, idx + 1);
        str2.deleteCharAt(str2.length() - 1);

        dfs(s, str1, str2, idx + 1);
        return;
    }
    boolean isValid(StringBuilder str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}