class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int n2 = dictionary.size();
        char[] array = s.toCharArray();
       // Arrays.sort(array);
        String max = "";
        for (int i = 0; i < n2; i++) {
            int idx = i;
            String str = dictionary.get(i);
            char[] temp = str.toCharArray();
          //  Arrays.sort(temp);
            int ans = function(array, temp, idx);
            if (ans >= 0 && dictionary.get(ans).length() > max.length()) {
                max = dictionary.get(ans);
            } else if (ans >= 0 && max.length() == dictionary.get(ans).length()) {
                int result = max.compareTo(dictionary.get(ans));
                if (result > 0) {
                    max = dictionary.get(ans);
                }
            }
        }
        return max;
    }

    int function(char[] array, char[] temp, int idx) {
        if (array.length < temp.length) {
            return -1;
        }
        int j = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {

            if (array[i] == temp[j]) {
                count++;
                j++;
            }
            if (count == temp.length) {
                return idx;
            }
        }
        return -1;
    }
}