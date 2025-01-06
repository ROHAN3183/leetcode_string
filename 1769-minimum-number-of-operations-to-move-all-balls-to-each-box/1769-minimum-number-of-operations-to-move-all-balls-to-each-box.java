class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int i = 0;
        int j;
        int k;
        int[] result = new int[n];
        
        while (i < n) {
            int count1 = 0;
            int count2 = 0;
            j = n - 1;
            k = 0;

            while (i < j) {
                if (boxes.charAt(j) == '1') {
                    count1 += j - i;
                }
                j--;
            }

            while (k < i) {
                if (boxes.charAt(k) == '1') {
                    count2 += i - k;
                }
                k++;
            }

            result[i] = count1 + count2;
            i++;
        }

        return result;
    }
}
