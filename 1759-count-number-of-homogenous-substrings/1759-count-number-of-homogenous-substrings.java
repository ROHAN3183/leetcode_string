class Solution {
    public int countHomogenous(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int result = 0;
        int first_ans = 0;
        int count = 0;
        int ans = 0;
        int last_ans = 0;
        int last_res = 0;
        final int MOD = 1000000007; // Modulo value

        while (j < n) {
            if (s.charAt(i) != s.charAt(j)) {
                count = j - i;
                // Calculate (count * (count + 1) / 2) % MOD using modulo arithmetic
                ans = (count * (count + 1) / 2) % MOD;
                first_ans = (first_ans + ans) % MOD; // Take modulo at each step
                i = j;
            }
            j++;
        }
        
        // For the last segment after the loop ends
        last_ans = n - i;
        last_res = (last_ans * (last_ans + 1) / 2) % MOD; // Apply modulo here

        result = (first_ans + last_res) % MOD; // Final result modulo
        return result;
    }
}
