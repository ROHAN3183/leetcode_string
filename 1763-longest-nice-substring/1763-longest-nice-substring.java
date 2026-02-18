class Solution {
    public String longestNiceSubstring(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String str = "";
            int[] map_small = new int[26];
            int[] map_cap = new int[26];
            for (int j = i; j < s.length(); j++) {
                str = str + s.charAt(j);
                if (isvalid(s.charAt(j), map_small, map_cap)) {
                    if (max.length() < str.length()) {
                        max = str;
                    }
                }
            }
        }
        return max;
    }

    boolean isvalid(char ch, int[] map_small, int[] map_cap) {
        int ascii = (int) ch;
        if (ascii >= 65 && ascii <= 90) {
            map_cap[ascii - 'A']++;
        } else {
            map_small[ascii - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((map_cap[i] <= 0 && map_small[i] > 0) || (map_cap[i] > 0 && map_small[i] <= 0)) {
                return false;
            }
        }
        return true;
    }
}