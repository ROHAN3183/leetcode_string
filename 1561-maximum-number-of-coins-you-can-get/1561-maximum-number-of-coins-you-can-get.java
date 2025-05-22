class Solution {
    public int maxCoins(int[] piles) {

        int n = piles.length;
        Integer[] boxedPiles=Arrays.stream(piles).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedPiles, Collections.reverseOrder());
       // int[] temp = new int[3];
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i + 1 <= j - 1) {
 
            count = count + boxedPiles[i+1];
            i=i+2;
            j--;
        }

        return count;
    }
}