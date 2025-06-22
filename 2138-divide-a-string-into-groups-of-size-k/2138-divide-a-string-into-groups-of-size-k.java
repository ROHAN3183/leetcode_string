class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();

        Stack<Character> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            stack.push(s.charAt(i));

        }

        while (!stack.isEmpty()) {

            String ans = "";
            int count = k;

            while (!stack.isEmpty() && count > 0) {
                ans += stack.pop();
                count--;

            }
            while (ans.length() < k) {
                ans += fill;
            }
            result.add(ans);

        }

        String[] array = result.toArray(new String[0]);
        return array;
    }
}