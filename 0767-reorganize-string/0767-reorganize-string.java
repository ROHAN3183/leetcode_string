import java.util.AbstractMap; 
class Solution {
    public String reorganizeString(String s) {
        StringBuilder str = new StringBuilder();
        int n = s.length();
        int freq[] = new int[26];
        Arrays.fill(freq, 0);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            if (freq[ch - 'a'] > (n + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                char ch = (char) ('a' + i);
                maxHeap.add(new AbstractMap.SimpleEntry<>(ch, freq[i]));
            }
        }

        Map.Entry<Character, Integer> prev = null;

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            str.append(current.getKey());
            current.setValue(current.getValue() - 1);

            if (prev != null && prev.getValue() > 0) {
                maxHeap.add(prev);
            }

            prev = current;
        }

        return str.toString();
    }
}
