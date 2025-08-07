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
        Set<Integer> deletedIdx = new HashSet<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.value == b.value) {
                return b.idx - a.idx;
            } else {
                return a.value - b.value;
            }
        });

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                minHeap.offer(new Pair(ch, i));
            } else {
                Pair delete = minHeap.poll();
                deletedIdx.add(delete.idx);
            }
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) && !deletedIdx.contains(i)) {
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }
}
