class Solution {

    public int maxRepOpt1(String text) {

        int n = text.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(text.charAt(i),
                    map.getOrDefault(text.charAt(i), 0) + 1);
        }

        int max = 1;

        int i = 0;

        HashMap<Character, Integer> temp = new HashMap<>();

        for (int j = 0; j < n; j++) {

            temp.put(text.charAt(j),
                    temp.getOrDefault(text.charAt(j), 0) + 1);

            while (!isvalid(map, temp)) {

                int freq = temp.get(text.charAt(i));

                if (freq == 1) {
                    temp.remove(text.charAt(i));
                } else {
                    temp.put(text.charAt(i), freq - 1);
                }

                i++;
            }

            max = Math.max(max, j - i + 1);
        }

        return max;
    }

    boolean isvalid(HashMap<Character, Integer> map,
                    HashMap<Character, Integer> temp) {

        if (temp.size() > 2) {
            return false;
        }

        if (temp.size() == 1) {
            return true;
        }

        Character ch1 = null;
        Character ch2 = null;

        int f1 = 0;
        int f2 = 0;

        int idx = 0;

        for (Map.Entry<Character, Integer> entry : temp.entrySet()) {

            if (idx == 0) {
                ch1 = entry.getKey();
                f1 = entry.getValue();
            } else {
                ch2 = entry.getKey();
                f2 = entry.getValue();
            }

            idx++;
        }

        if (f1 == 1 && map.get(ch2) > f2) {
            return true;
        }

        if (f2 == 1 && map.get(ch1) > f1) {
            return true;
        }

        return false;
    }
}