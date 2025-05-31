class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String ans = "";
        combination(result, ans, n, 0, 0);
        return result;

    }

    void combination(List<String> result, String ans, int n, int open, int close) {
        if (ans.length() == 2 * n) {
            result.add(ans);
            return;

        }

        if (open < n) {
            combination(result, ans + '(', n, open + 1, close);
        }
        if (close < open) {
            combination(result, ans + ')', n, open, close + 1);
        }

    }
}