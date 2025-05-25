class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int score = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
                stack.pop();
                stack.push('1'); // Found ()
            } else if (ch == '(') {
                stack.push('(');
            } else if (!stack.isEmpty() && ch == ')') {
                int sum = 0;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char temp = stack.pop();
                    sum += (int)(temp - '0');  // Convert char to int
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // remove '('
                }
                sum *= 2;
                stack.push((char)(sum + '0')); // Convert int to char
            }
        }

        // Sum all characters in stack
        while (!stack.isEmpty()) {
            score += (int)(stack.pop() - '0');
        }

        return score;
    }
}
