class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        boolean flag = false;
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            char ch = entry.getKey();
            if (freq % 2 != 0) {
                flag = true;
            }
            count += 2 * (freq / 2);

        }
        if (flag) {
            return count + 1;
        }
        return count;

    }
}