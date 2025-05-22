class Solution {
    public int maxCoins(int[] piles) {

        int n = piles.length;
        Arrays.sort(piles);
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i + 1 <= j - 1) {

            count = count + piles[j - 1];
            i = i + 1;
            j = j - 2;
        }

        return count;
    }
}