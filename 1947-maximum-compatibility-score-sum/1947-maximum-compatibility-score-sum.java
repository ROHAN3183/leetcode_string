class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] used = new boolean[mentors.length];
        return dfs(students, mentors, used, 0);
    }

    int dfs(int[][] students, int[][] mentors, boolean[] used, int idx) {
        if (idx == students.length) {
            return 0;
        }
        int[] s = students[idx];
        int best = 0;
        for (int i = 0; i < mentors.length; i++) {
            int[] m = mentors[i];
            if (!used[i]) {
                used[i] = true;
                int score = check(s, m) + dfs(students, mentors, used, idx + 1);
                best = Math.max(score, best);
                used[i] = false;
            }
        }
        return best;
    }

    int check(int[] s, int[] m) {
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == m[i]) {
                count++;
            }
        }
        return count;
    }
}