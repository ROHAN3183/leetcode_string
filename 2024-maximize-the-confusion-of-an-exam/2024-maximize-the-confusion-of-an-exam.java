class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int resultTrue = maxTrue(answerKey, k);
        int resultFalse = maxFalse(answerKey, k);
        return Math.max(resultTrue, resultFalse);
    }

    int maxTrue(String answerKey, int k) {
        int n = answerKey.length();
        int i = 0, j = 0;
        int count = 0;
        int maxSizeTrue = 0;
        while (j < n) {
            if (answerKey.charAt(j) != 'T') {
                count++;
            }
            while (count > k) {
                if (answerKey.charAt(i) != 'T') {
                    count--;
                }
                i++;
            }
            maxSizeTrue = Math.max(maxSizeTrue, j - i + 1);
            j++;
        }
        return maxSizeTrue;
    }

    int maxFalse(String answerKey, int k) {
        int n = answerKey.length();
        int i = 0, j = 0;
        int count = 0;
        int maxSizeFalse = 0;
        while (j < n) {
            if (answerKey.charAt(j) != 'F') {
                count++;
            }
            while (count > k) {
                if (answerKey.charAt(i) != 'F') {
                    count--;
                }
                i++;
            }
            maxSizeFalse = Math.max(maxSizeFalse, j - i + 1);
            j++;
        }
        return maxSizeFalse;
    }
}