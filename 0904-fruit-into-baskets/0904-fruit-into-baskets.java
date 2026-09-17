class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        while (j < fruits.length) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            while (map.size() > 2) {
                int val = map.get(fruits[i]);
                if (val == 1) {
                    map.remove(fruits[i]);
                } else {
                    map.put(fruits[i], val - 1);
                }
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}