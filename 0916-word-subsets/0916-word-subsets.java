class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        
        // Step 1: Calculate the maximum frequency requirement for words2
        int[] freq2 = new int[26]; // Frequency array for all characters
        for (String word : words2) {
            int[] temp = new int[26]; // Temporary frequency array for the current word
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']++;
                freq2[ch - 'a'] = Math.max(freq2[ch - 'a'], temp[ch - 'a']);
            }
        }
        
        // Step 2: Check each word in words1
        for (String word : words1) {
            int[] temp = new int[26]; // Frequency array for the current word
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']++;
            }
            
            // Check if the word satisfies the universal condition
            if (isSubset(freq2, temp)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    // Helper method to check if freq2 is a subset of temp
    private boolean isSubset(int[] freq2, int[] temp) {
        for (int i = 0; i < 26; i++) {
            if (temp[i] < freq2[i]) {
                return false; // Not a subset
            }
        }
        return true;
    }
}