class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Pair> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

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

        // New matching logic
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Pair top = stack1.pop();

            if (top.ch == '(') {
        // Match '(' with '*' after it
            if (stack2.peek() > top.num) {
                stack2.pop();
            } else {
            // No '*' after this '('
                return false;
            }
            } else { // top.ch == ')'
        // Match ')' with '*' before it
                if (stack2.peek() < top.num) {
                stack2.pop();
                } else {
            // No '*' before this ')'
                    return false;
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