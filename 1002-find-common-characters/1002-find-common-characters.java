class Solution {
    public List<String> commonChars(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> temp = new HashMap<>();
        List<String> list = new ArrayList<>();
        String word = words[0];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 1; i < words.length; i++) {

            String wor = words[i];
            int j = 0;

            while (j < wor.length()) {
                char ch = wor.charAt(j);
                temp.put(ch, temp.getOrDefault(ch, 0) + 1);
                j++;
            }
            List<Character> toRemove = new ArrayList<>();
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                char ch = entry.getKey();
                int freq1 = entry.getValue();
                if (temp.containsKey(ch)) {
                    int freq2 = temp.get(ch);
                    int freq = Math.min(freq1, freq2);
                    map.put(ch, freq);
                } else {
                    toRemove.add(ch);
                }
            }
            for (char key : toRemove) {
                map.remove(key);
            }
            temp.clear();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            String str = entry.getKey().toString();
            int freq = entry.getValue();
            while (freq > 0) {
                list.add(str);
                freq--;
            }
        }
        return list;
    }
}