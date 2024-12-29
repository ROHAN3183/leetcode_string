class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        boolean[] used = new boolean[26];
        int[] lastIndex = new int[26];
        // Track the last occurrence of each character
        for (int k = 0; k < n; k++) {
            lastIndex[s.charAt(k) - 'a'] = k;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // Skip this character if it's already used
            if (used[ch - 'a']) continue;
            // Remove characters from the result if they:
            // 1. Are greater than the current character
            // 2. Appear later in the string
            while (result.length() > 0 &&
                   result.charAt(result.length() - 1) > ch &&
                   lastIndex[result.charAt(result.length() - 1) - 'a'] > i) {
                used[result.charAt(result.length() - 1) - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }
            // Add the current character to the result
            result.append(ch);
            used[ch - 'a'] = true;
        }
        return result.toString();
    }
}
