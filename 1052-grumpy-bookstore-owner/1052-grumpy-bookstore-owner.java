class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        int alreadySatisfied = 0;

        for (int k = 0; k < n; k++) {
            if (grumpy[k] == 0) {
                alreadySatisfied += customers[k];
            }
        }

        while (j < n) {
            if (grumpy[j] == 1) {
                count += customers[j];
            }
            while (j - i + 1 > minutes) {
                if (grumpy[i] == 1) {
                    count -= customers[i];
                }
                i++;
            }
            if (j - i + 1 == minutes) {
                max = Math.max(max, count);
            }
            j++;
        }

        return alreadySatisfied + max;
    }
}