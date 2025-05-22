class Solution {
    public int maxCoins(int[] piles) {

        int n = piles.length;
        Arrays.sort(piles);
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i < j) {

            count = count + piles[j - 1];
            i = i + 1;
            j = j - 2;
        }

        return count;
    }
}