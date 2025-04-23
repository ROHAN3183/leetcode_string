import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        StringBuilder str = new StringBuilder();
        int n = s.length();
        int[] freq = new int[26];
        Arrays.fill(freq, 0);

        // Count character frequencies and check feasibility
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            if (freq[ch - 'a'] > (n + 1) / 2) {
                return ""; // Not possible
            }
        }

        // Max Heap with frequency and character (using Map.Entry)
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                char ch = (char) ('a' + i);
                maxHeap.add(new AbstractMap.SimpleEntry<>(ch, freq[i]));
            }
        }

        // Two-by-two greedy pick from heap
        while (maxHeap.size() >= 2) {
            Map.Entry<Character, Integer> first = maxHeap.poll();
            Map.Entry<Character, Integer> second = maxHeap.poll();

            str.append(first.getKey());
            str.append(second.getKey());

            int newCount1 = first.getValue() - 1;
            int newCount2 = second.getValue() - 1;

            if (newCount1 > 0) {
                maxHeap.add(new AbstractMap.SimpleEntry<>(first.getKey(), newCount1));
            }
            if (newCount2 > 0) {
                maxHeap.add(new AbstractMap.SimpleEntry<>(second.getKey(), newCount2));
            }
        }

        // Add the last remaining character if any
        if (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> last = maxHeap.poll();
            str.append(last.getKey());
        }

        return str.toString();
    }
}
