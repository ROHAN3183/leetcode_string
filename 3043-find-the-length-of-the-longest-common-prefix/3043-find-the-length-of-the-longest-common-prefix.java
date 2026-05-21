class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr1.length; i++) {
            String str = "" + arr1[i];
            String temp = "";
            for (int j = 0; j < str.length(); j++) {
                temp = temp + str.charAt(j);
                map.put(temp, temp.length());
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            String str = "" + arr2[i];
            String temp = "";
            for (int j = 0; j < str.length(); j++) {
                temp += str.charAt(j);
                if (map.containsKey(temp)) {
                    max = Math.max(max, map.get(temp));
                } else {
                    break;
                }
            }
        }
        return max;
    }
}