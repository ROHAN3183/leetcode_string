class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;
        int countRequired = t.length();
        int minIndx = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        while (j < n) {
            char c = s.charAt(j);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);

                if (map.get(c) >= 0) {
                    countRequired--;
                }
            }

            while (countRequired <= 0) {
                char ch = s.charAt(i);

                if (min > j - i + 1) {
                    min = Math.min(min, j - i + 1);
                    minIndx = i;
                }

                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);

                    if (map.get(ch) > 0) {
                        countRequired++;
                    }
                }

                i++;
            }

            j++;
        }

        if (min == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minIndx, minIndx + min);
    }
}