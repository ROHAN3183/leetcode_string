class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        int start = -1;
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
                if (max < count) {
                    max = count;
                    start = i;

                }
            }
            j++;
        }

        if (start == -1) {
            return alreadySatisfied;
        }

        for (int k = start; k < start + minutes; k++) {
            if (grumpy[k] == 1) {
                alreadySatisfied += customers[k];
            }
        }
        return alreadySatisfied;
    }
}