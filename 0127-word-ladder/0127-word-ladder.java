class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        boolean[] visited = new boolean[n];
        int res = dfs(wordList, beginWord, endWord, visited);
        return res == Integer.MAX_VALUE ? 0 : res + 1;
    }

    int dfs(List<String> wordList, String beginWord, String endWord, boolean[] visited) {
        if (isAnswer(beginWord, endWord)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wordList.size(); i++) {
            if (!visited[i] && isValid(beginWord, wordList.get(i))) {
                visited[i] = true;
                int val = dfs(wordList, wordList.get(i), endWord, visited);
                if (val != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + val);
                }
                visited[i] = false;
            }
        }
        return min;
    }

    boolean isValid(String prev, String next) {
        if (prev.length() > next.length() || prev.length() < next.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        int diff = 0;
        int n = prev.length();
        while (i < n) {
            if (prev.charAt(i) != next.charAt(j)) {
                diff++;
            }
            i++;
            j++;
        }
        return diff == 1;

    }

    boolean isAnswer(String beginWord, String endWord) {
        if (beginWord.length() > endWord.length() || beginWord.length() < endWord.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        int n = beginWord.length();
        while (i < n && j < n) {
            if (beginWord.charAt(i) != endWord.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}