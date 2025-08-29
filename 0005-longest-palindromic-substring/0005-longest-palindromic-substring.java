class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < n; j++) {
                String toCheck = s.substring(i, j + 1);
                boolean valid = solver(toCheck, 0, toCheck.length() - 1);
                if (valid && max.length() < toCheck.length()) {
                    max = toCheck;
                }
            }
        }
        return max;
    }

    boolean solver(String toCheck, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (toCheck.charAt(i) == toCheck.charAt(j)) {
            return solver(toCheck, i + 1, j - 1);
        }
        return false;

    }
}