class Solution {
    Integer[][][] increMemo;
    Integer[][][] decreMemo;

    public int numTeams(int[] rating) {
        int n = rating.length;
        increMemo = new Integer[n][n+1][4];
        decreMemo = new Integer[n][n+1][4];
        return dfs1(rating, 0, -1, 0) + dfs2(rating, 0, -1, 0);
    }

    int dfs1(int[] rating, int idx, int prev, int len) {
        if (len == 3) return 1;
        if (idx >= rating.length) return 0;

        if (increMemo[idx][prev + 1][len] != null)
            return increMemo[idx][prev + 1][len];

        int take = 0;
        if (prev == -1 || rating[idx] > rating[prev]) {
            take = dfs1(rating, idx + 1, idx, len + 1);
        }
        int not_take = dfs1(rating, idx + 1, prev, len);

        return increMemo[idx][prev + 1][len] = take + not_take;
    }

    int dfs2(int[] rating, int idx, int prev, int len) {
        if (len == 3) return 1;
        if (idx >= rating.length) return 0;

        if (decreMemo[idx][prev + 1][len] != null)
            return decreMemo[idx][prev + 1][len];

        int take = 0;
        if (prev == -1 || rating[idx] < rating[prev]) {
            take = dfs2(rating, idx + 1, idx, len + 1);
        }
        int not_take = dfs2(rating, idx + 1, prev, len);

        return decreMemo[idx][prev + 1][len] = take + not_take;
    }
}
