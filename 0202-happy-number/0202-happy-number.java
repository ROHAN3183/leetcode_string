class Solution {
    int num;

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        num = n;
        while (!set.contains(num)) {
            if (num == 1) {
                return true;
            }
            set.add(num);
            compute(num);
        }
        return false;
    }

    void compute(int num) {
        int newNum = 0;
        while (num > 0) {
            int digit = num % 10;
            newNum += digit * digit;
            num = num / 10;
        }
        this.num = newNum;
    }
}
