class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = i; j < n; j++) {
                str = str + s.charAt(j);

                if (isValid(str) && str.length()%2==0) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean isValid(String str) {
        char ch = str.charAt(0);
        int n = str.length();

        if (n % 2 != 0) {
            return false;
        }
        return compute(str, '0', '1') || compute(str, '1', '0');
    }

    boolean compute(String str, char ch1, char ch2) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) == ch2) {
                return false;
            }
        }
        for (int i = n / 2; i < n; i++) {
            if (str.charAt(i) == ch1) {
                return false;
            }
        }
        return true;
    }
}