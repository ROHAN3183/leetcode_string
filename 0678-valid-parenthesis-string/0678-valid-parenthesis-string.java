import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Pair> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // First pass: match parentheses and collect asterisks
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                stack2.push(i);
            } else if (ch == '(') {
                stack1.push(new Pair(ch, i));
            } else {
                if (!stack1.isEmpty() && stack1.peek().ch == '(') {
                    stack1.pop();
                } else {
                    stack1.push(new Pair(ch, i));
                }
            }
        }

        // Second pass: try to match remaining parentheses with asterisks
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Pair top = stack1.peek();
            int starPos = stack2.peek();
            
            if (top.ch == '(') {
                if (starPos > top.num) {
                    stack1.pop();
                    stack2.pop();
                } else {
                    // No matching asterisk after this '('
                    break;
                }
            } else { // top.ch == ')'
                if (starPos < top.num) {
                    stack1.pop();
                    stack2.pop();
                } else {
                    // No matching asterisk before this ')'
                    break;
                }
            }
        }

        return stack1.isEmpty();
    }

    class Pair {
        char ch;
        int num;
        Pair(char ch, int num) {
            this.ch = ch;
            this.num = num;
        }
    }
}