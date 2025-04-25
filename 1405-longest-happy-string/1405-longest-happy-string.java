import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());

        if (a > 0) {
            maxHeap.add(new AbstractMap.SimpleEntry<>('a', a));
        }
        if (b > 0) {
            maxHeap.add(new AbstractMap.SimpleEntry<>('b', b));
        }
        if (c > 0) {
            maxHeap.add(new AbstractMap.SimpleEntry<>('c', c));
        }

        StringBuilder str = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> temp1 = maxHeap.poll();

            if (str.length() >= 2 && 
                str.charAt(str.length() - 1) == temp1.getKey() &&
                str.charAt(str.length() - 2) == temp1.getKey()) {

                if (!maxHeap.isEmpty()) {
                    Map.Entry<Character, Integer> temp2 = maxHeap.poll();
                    str.append(temp2.getKey());
                    temp2.setValue(temp2.getValue() - 1);
                    if (temp2.getValue() > 0) {
                        maxHeap.add(temp2);
                    }
                    // Add temp1 back to the heap after processing temp2
                    maxHeap.add(temp1);
                } else {
                    // If no other characters available, we can't add more
                    break;
                }
            } else {
                str.append(temp1.getKey());
                temp1.setValue(temp1.getValue() - 1);
                if (temp1.getValue() > 0) {
                    maxHeap.add(temp1);
                }
            }
        }

        return str.toString();
    }
}