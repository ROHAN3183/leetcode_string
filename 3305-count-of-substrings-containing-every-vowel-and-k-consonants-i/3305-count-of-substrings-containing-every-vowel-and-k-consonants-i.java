class Solution {
    public int countOfSubstrings(String word, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = word.length();
        int[] nextConsonant = new int[n];
        int consonant = 0;
        int lastSeen = n;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            nextConsonant[i] = lastSeen;
            if (!isVowel(word.charAt(i))) {
                lastSeen = i;
            }
        }

        int i = 0;
        int j = 0;
        while (j < n) {
            char ch = word.charAt(j);
            if (isVowel(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            } else {
                consonant++;
            }
            while (i <= j && consonant > k) {
                char cha = word.charAt(i);
                if (isVowel(cha)) {
                    int freq = map.get(cha);
                    if (freq == 1) {
                        map.remove(cha);
                    } else {
                        map.put(cha, freq - 1);
                    }
                } else {
                    consonant--;
                }
                i++;
            }
            while (map.size() >= 5 && consonant == k) {
                count += nextConsonant[j] - j;
                char cha = word.charAt(i);
                if (isVowel(cha)) {
                    int freq = map.get(cha);
                    if (freq == 1) {
                        map.remove(cha);
                    } else {
                        map.put(cha, freq - 1);
                    }
                } else {
                    consonant--;
                }
                i++;

            }
            j++;
        }
        return count;

    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}