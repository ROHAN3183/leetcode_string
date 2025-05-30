class Solution {
    HashMap<Integer, String> map = new HashMap<>(); // Moved outside so it's accessible in both methods

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String temp = "";
        int size = digits.length();
        String[] store = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 2; i < 10; i++) {
            map.put(i, store[i - 2]);
        }

        if (digits.length() == 0) return result;
        combination(temp, result, digits, 0, size);
        return result;
    }

    void combination(String temp, List<String> result, String digits, int index, int size) {
        if (temp.length() == size) {
            result.add(temp);
            return;
        }

        int num = digits.charAt(index) - '0'; // Convert character to corresponding number
        String str = map.get(num);

        for (int i = 0; i < str.length(); i++) {
            temp += str.charAt(i);
            combination(temp, result, digits, index + 1, size);
            temp = temp.substring(0, temp.length() - 1); // Backtrack
        }
    }
}
