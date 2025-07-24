class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<Character, Integer> mapFreq = new HashMap<>();
        HashMap<String, Integer> mapString = new HashMap<>();
        StringBuilder str = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int n = s.length();
        int i = 0;
        int j = 0;
        while (j < n) {

            str.append(s.charAt(j));
            mapFreq.put(s.charAt(j), mapFreq.getOrDefault(s.charAt(j), 0) + 1);

            while (j - i + 1 > minSize) {
                char ch = s.charAt(i);

                mapFreq.put(ch, mapFreq.getOrDefault(ch, 0) - 1);
                str.deleteCharAt(0);

                if (mapFreq.get(ch) <= 0) {
                    mapFreq.remove(ch);
                }
                i++;
            }

            if (j - i + 1 >= minSize && mapFreq.size() <= maxLetters) {
                String ans = str.toString();
                mapString.put(ans, mapString.getOrDefault(ans, 0) + 1);
            }
            j++;
        }
        for (Integer value : mapString.values()) {
            max = max = Math.max(value, max);
        }
        return max;
    }
}