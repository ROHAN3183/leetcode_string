class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int maxScore = 0;
        for (int i = 0; i < k; i++) {
            maxScore += cardPoints[i];
            max = Math.max(max, maxScore);
        }
        int idx = cardPoints.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            maxScore -= cardPoints[i];
            maxScore += cardPoints[idx--];
            max = Math.max(max, maxScore);
        }
        return max;
    }
}