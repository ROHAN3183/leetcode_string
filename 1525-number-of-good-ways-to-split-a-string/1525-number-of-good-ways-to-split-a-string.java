class Solution {
    public int numSplits(String s) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int[] prefix1 = new int[s.length()];
        int[] prefix2 = new int[s.length()];
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(s.charAt(j), map2.getOrDefault(s.charAt(j), 0) + 1);
            prefix1[i] = map1.size();
            prefix2[j] = map2.size();
            j--;
        }
        j = 0;
        int count = 0;
        for (int i = 1; i < prefix1.length; i++) {
            if (prefix1[i] == prefix2[j]) {
                count++;
            }
        }
        return count;
    }
}