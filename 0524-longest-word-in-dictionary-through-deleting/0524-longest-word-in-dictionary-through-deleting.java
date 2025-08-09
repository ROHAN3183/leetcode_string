class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int n2 = dictionary.size();
        String max = "";
        for (int i = 0; i < n2; i++) {
            int idx = i;
            String str = dictionary.get(i);
            int ans = function(s, str, idx);
            if (ans >= 0 && dictionary.get(ans).length() > max.length()) {
                max = dictionary.get(ans);
            } else if (ans >= 0 && max.length() == dictionary.get(ans).length()) {
                int result = max.compareTo(dictionary.get(ans));
                if (result > 0) {
                    max = dictionary.get(ans);
                }
            }
        }
        return max;
    }

    int function(String s, String word, int idx) {
        if (s.length() < word.length()) {
            return -1;
        }
        int j = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == word.charAt(j)) {
                count++;
                j++;
                if (count == word.length()) {
                    return idx;
                }
            }
        }
        return -1;
    }
}
