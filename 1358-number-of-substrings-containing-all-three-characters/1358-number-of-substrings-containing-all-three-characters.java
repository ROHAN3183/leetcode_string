class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while (map.size() >= 3) {
                if (map.size() == 3) {
                    count += s.length() - j;
                }
                int val = map.get(s.charAt(i));
                if (val == 1) {
                    map.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), val - 1);
                }
                i++;
            }
            j++;
        }
        return count;
    }
}