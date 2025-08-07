class Solution {
    class Pair {
        char value;
        int idx;

        Pair(char value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    public String clearStars(String s) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.value == b.value) {
                return b.idx - a.idx;
            } else {
                return a.value - b.value;
            }
        });
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                minHeap.offer(new Pair(ch, i));
            } else {
                Pair delete = minHeap.poll();
                int freq = map.get(delete.value);
                if (freq == 1) {
                    map.remove(delete.value);
                } else {
                    map.put(delete.value, freq - 1);
                }
                list.add(delete.idx);
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch) && map.containsKey(ch) && !list.contains(i)) {
                str.append(ch);
                int freq = map.get(ch);
                if (freq == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, freq - 1);
                }
            }
        }
        return str.toString();
    }
}