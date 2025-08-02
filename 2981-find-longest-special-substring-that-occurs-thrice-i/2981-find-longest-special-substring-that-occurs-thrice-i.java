class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    String str = s.substring(i, j + 1);
                    map.put(str, map.getOrDefault(str, 0) + 1);
                } else {
                    break;
                }
            }
        }

        int length = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value >= 3 && length < key.length()) {
                length = key.length();
            }
        }
        return length;
    }
}