class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder str = new StringBuilder();
        int n = s.length();
        int[] frequency = new int[26];
        
        // Count the frequency of each character
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            frequency[ch - 'a'] += 1;
        }
        
        int i = 25; // Start from the largest character
        while (i >= 0) {
            if (frequency[i] > 0) {
                char ch = (char) (i + 97); // Correct casting
                
                // Append up to 'repeatLimit' characters
                int count = Math.min(frequency[i], repeatLimit);
                for (int p = 0; p < count; p++) {
                    str.append(ch);
                }
                frequency[i] -= count;

                // If characters are left, find the next smaller character
                if (frequency[i] > 0) {
                    int j = i - 1;
                    while (j >= 0 && frequency[j] == 0) {
                        j--;
                    }
                    if (j >= 0 && frequency[j] > 0) {
                        char mid = (char) (j + 97);
                        str.append(mid);
                        frequency[j]--; // Decrease frequency of the smaller character
                    } else {
                        break; // No smaller characters available, terminate early
                    }
                }
            }
            if (frequency[i] == 0) {
                i--; // Move to the next smaller character
            }
        }
        
        return str.toString();
    }
}
