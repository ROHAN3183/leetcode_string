class Solution {
    public boolean checkStrings(String s1, String s2) {
        HashMap<Character, Integer> even_map = new HashMap<>();
        HashMap<Character, Integer> odd_map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                even_map.put(s1.charAt(i), even_map.getOrDefault(s1.charAt(i), 0) + 1);
            } else {
                odd_map.put(s1.charAt(i), odd_map.getOrDefault(s1.charAt(i), 0) + 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (i % 2 == 0) {
                if (even_map.containsKey(s2.charAt(i))) {
                    if (even_map.get(s2.charAt(i)) == 1) {
                        even_map.remove(s2.charAt(i));
                    } else {
                        int val = even_map.get(s2.charAt(i));
                        even_map.put(s2.charAt(i), val - 1);
                    }
                } else {
                    return false;
                }
            } else {
                if (odd_map.containsKey(s2.charAt(i))) {
                    if (odd_map.get(s2.charAt(i)) == 1) {
                        odd_map.remove(s2.charAt(i));
                    } else {
                        int val = odd_map.get(s2.charAt(i));
                        odd_map.put(s2.charAt(i), val - 1);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}