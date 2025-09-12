class Solution {
    class Pair {
        String key;
        int freq;

        Pair(String key, int freq) {
            this.key = key;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq) {
                return b.key.compareTo(a.key);
            }
            return a.freq - b.freq;
        });

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            while (pq.size() > k) {
                pq.poll();
            }

        }
        while (!pq.isEmpty()) {
            list.add(pq.poll().key);
        }
        Collections.reverse(list);
        return list;
    }
}