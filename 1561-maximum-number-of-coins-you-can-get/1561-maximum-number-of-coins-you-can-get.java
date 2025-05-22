class Solution {
    public int maxCoins(int[] piles) {

        int n = piles.length;
        Integer[] boxedPiles=Arrays.stream(piles).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedPiles, Collections.reverseOrder());
        int[] temp = new int[3];
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i + 1 <= j - 1) {
            temp[0] = boxedPiles[i];
            temp[1] = boxedPiles[i + 1];
            temp[2] = boxedPiles[j];
            count = count + temp[1];
            i=i+2;
            j--;
        }

        return count;
    }
}