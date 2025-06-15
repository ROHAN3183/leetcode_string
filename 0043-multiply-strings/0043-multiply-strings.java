class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int n = num1.length();
        int m = num2.length();
        int[] product = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                int up = num1.charAt(i) - '0';
                int down = num2.charAt(j) - '0';

                int mul = up * down;
                int sum = mul + product[i + j + 1];
                product[i + j + 1] = sum % 10;
                product[i + j] += sum / 10;

            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < product.length; i++) {
            if (sb.length() == 0 && product[i] == 0) {
                continue;
            }
            sb.append(product[i]);
        }
        return sb.toString();

    }
}