class Solution {
    int max = 0;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] used = new boolean[mentors.length];
        dfs(students, mentors, used, 0, 0);
        return max;
    }

    void dfs(int[][] students, int[][] mentors, boolean[] used, int idx, int ans) {
        if (idx == students.length) {
            max = Math.max(max, ans);
            return;
        }

        int[] s = students[idx];
        for (int i = 0; i < mentors.length; i++) {
            int[] m = mentors[i];
            if (!used[i]) {
                used[i] = true;
                ans += check(s, m);
                dfs(students, mentors, used, idx + 1, ans);
                ans -= check(s, m);
                used[i] = false;
            }
        }
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