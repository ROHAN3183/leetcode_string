class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a > 0 || b > 0 || c > 0) {
            int result = ((a & 1) | (b & 1));
            int target = c & 1;
            if (result != target) {
                if ((result == 0) && (target == 1)) {
                    count++;
                } else {
                    if ((a & 1) == 1 && (b & 1) == 1) {
                        count += 2;
                    } else if (((a & 1) == 1 && (b & 1) == 0) || ((a & 1) == 0 && (b & 1) == 1)) {
                        count++;
                    }
                }
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return count;
    }
}