class Solution {
    class Pair {
        String word;
        int step;

        Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        queue.offer(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            String word = curr.word;
            int step = curr.step;

            if (word.equals(endWord)) {
                return step;
            }

            for (int i = 0; i < wordList.size(); i++) {
                if (!visited[i] && isValid(word, wordList.get(i))) {
                    visited[i] = true;
                    queue.offer(new Pair(wordList.get(i), step + 1));
                }
            }
        }

        return 0;
    }

    boolean isValid(String prev, String next) {
        if (prev.length() != next.length()) return false;
        int diff = 0;
        for (int i = 0; i < prev.length(); i++) {
            if (prev.charAt(i) != next.charAt(i)) diff++;
        }
        return diff == 1;
    }
}
