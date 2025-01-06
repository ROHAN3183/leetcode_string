class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        String ans = "";
        int result = 0;
        int[] operation = new int[n];
        
        // Construct the string `ans` containing all the '1' characters
        for (int i = 0; i < n; i++) {
            char ch = boxes.charAt(i);
            if (ch == '1') {
                ans = ans + i; // Append index of '1' instead of the character
            }
        }

        // Compute the operations for each box
        for (int i = 0; i < n; i++) {
            result = 0; // Reset the result for each box
            for (int j = 0; j < ans.length(); j++) {
                int num = ans.charAt(j) - '0'; // Convert character to integer index
                result += Math.abs(num - i); // Calculate distance
            }
            operation[i] = result; // Store the result for box `i`
        }
        
        return operation;
    }
}
