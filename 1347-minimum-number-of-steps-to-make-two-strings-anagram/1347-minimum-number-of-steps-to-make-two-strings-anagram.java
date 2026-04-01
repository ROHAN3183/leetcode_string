class Solution {
    public int minSteps(String s, String t) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr1[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            arr2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                count += Math.abs(arr1[i] - arr2[i]);
            }
        }
        return count/2;

    }
}