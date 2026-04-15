class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        if (words[startIndex].equals(target)) {
            return 0;
        }
        int forwardStep = 0;
        int k = startIndex;
        for (int i = 0; i < n; i++) {
            if (words[k % n].equals(target)) {
                break;
            }
            forwardStep++;
            k++;
        }
        int backwardStep = 0;
        k = startIndex;
        for (int i = 0; i < n; i++) {
            if (words[k % n].equals(target)) {
                break;
            }
            backwardStep++;
            k = (k - 1 + n) % n;
        }
        if (forwardStep > n - 1 && backwardStep > n - 1) {
            return -1;
        }
        return Math.min(forwardStep, backwardStep);
    }
}