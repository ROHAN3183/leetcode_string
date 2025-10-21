class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        return bfs(wordList, beginWord, endWord, queue);

    }

    int bfs(List<String> wordList, String beginWord, String endWord, Queue<String> queue) {
        queue.offer(beginWord);
        boolean[] visited = new boolean[wordList.size()];
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return step;
                }
                for (int i = 0; i < wordList.size(); i++) {
                    if (!visited[i] && isValid(curr, wordList.get(i))) {
                        visited[i] = true;
                        queue.offer(wordList.get(i));

                    }
                }
            }
            step++;
        }
        return 0;
    }

    boolean isValid(String prev, String next) {
        if (prev.length() != next.length())
            return false;
        int diff = 0;
        for (int i = 0; i < prev.length(); i++) {
            if (prev.charAt(i) != next.charAt(i))
                diff++;
        }
        return diff == 1;
    }
}