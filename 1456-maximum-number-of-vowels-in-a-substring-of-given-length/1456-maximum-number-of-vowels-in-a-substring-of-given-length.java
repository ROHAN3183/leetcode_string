class Solution {
    public int maxVowels(String s, int k) {
        int i = 0;
        int j = 0;
        int vowelCount = 0;
        int maxCount = 0;
        while (j < s.length()) {
            if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' ||
                    s.charAt(j) == 'o' || s.charAt(j) == 'u') {
                vowelCount++;
            }
            while (j - i + 1 > k) {
                if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
                        s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                    vowelCount--;
                }
                i++;
            }
            if (j - i + 1 == k) {
                maxCount = Math.max(maxCount, vowelCount);
            }
            j++;
        }
        return maxCount;
    }
}