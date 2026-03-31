class Solution {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int result = -1;
        for (int i = 0; i < n; i++) {
            String s = strs[i];
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubsequence(strs[i], strs[j])) {
                    found = true;
                    break;
                }

            }
            if (!found) {
                result = Math.max(result, strs[i].length());
            }
        }
        return result;
    }

    boolean isSubsequence(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i >= s1.length()) {
            return true;
        }
        return false;
    }
}