class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        String temp = "";
        combination(s, temp, result, 0);
        return result;
    }

    void combination(String s, String temp, List<String> result, int idx) {
        if (temp.length() == s.length()) {
            result.add(temp);
            return;
        }

        char ch = s.charAt(idx);
        if (Character.isLetter(ch)) {
            char upper = Character.toUpperCase(ch);
            combination(s, temp + upper, result, idx + 1); // fix 1: "Combination" → "combination"

            char lower = Character.toLowerCase(ch);
            combination(s, temp + lower, result, idx + 1); // fix 2: temp_lower → temp + lower
        } else {
            combination(s, temp + ch, result, idx + 1); // fix 3: keep digit in temp
        }
    }
}
