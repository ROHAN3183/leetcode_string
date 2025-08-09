class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (ch1 == ch2) {
                while (i < n - 1 && s.charAt(i) == ch1) {
                    i++;
                }
                while (j > 0 && s.charAt(j) == ch2) {
                    j--;
                }
            } else {
                break;
            }
        }
        if (j - i + 1 < 0) {
            return 0;
        }
        return j - i + 1;
    }
}