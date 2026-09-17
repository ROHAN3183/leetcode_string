class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                int n = map.get(s.charAt(j));
                int k = i;
                while (k <= n) {
                    int val = map.get(s.charAt(k));
                    if (val == 1) {
                        map.remove(s.charAt(k));
                    } else {
                        map.put(s.charAt(k), val - 1);
                    }
                    k++;

                }
                i = k;
            }
            map.put(s.charAt(j), j);

            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}