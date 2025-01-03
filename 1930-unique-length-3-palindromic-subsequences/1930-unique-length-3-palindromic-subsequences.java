class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int result = 0;
        Set<Character> set_palindrome = new HashSet<>();
        Set<Character> set = new HashSet<>();
        int[] index = new int[26];
        Arrays.fill(index, -1);
        
        // Record the last occurrence of each character in the string
        for (int idx = 0; idx < n; idx++) {
            index[s.charAt(idx) - 'a'] = idx;
        }
        
        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            
            // Check if the character can form a subsequence of length 3
            if (index[ch - 'a'] >= i + 2) {
                int j = index[ch - 'a'];
                int count = 0;
                
                // Check all characters between i and j (inclusive)
                if (!set_palindrome.contains(s.charAt(i))) {
                    for (int start = i + 1; start < j; start++) {
                        set.add(s.charAt(start));  // Add distinct characters between i and j
                    }
                    count = set.size();  // Number of distinct middle characters
                    set.clear();  // Reset the set for the next iteration
                }
                
                result += count;  // Add the count to the result
                set_palindrome.add(s.charAt(i));  // Mark the character as processed
            }
            i++;
        }
        
        return result;
    }
}
