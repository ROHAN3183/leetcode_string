class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int vowel_count = 0;
            int consonant_count = 0;

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (isVowel(ch)) {
                    vowel_count++;
                } else {
                    consonant_count++;
                }

                if (vowel_count == consonant_count && (vowel_count * consonant_count) % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}
