class Solution {
    public String[] findRelativeRanks(int[] score) {

        String[] result = new String[score.length];

        HashMap<Integer, Integer> map = new HashMap<>();

        String[] topper = { "Gold Medal", "Silver Medal", "Bronze Medal" };

        int[] dublicate = score.clone();
        Arrays.sort(dublicate);

        int n = score.length - 1;
        
        for (int i = dublicate.length - 1; i >= 0; i--) {

            map.put(dublicate[i], n - i);
        }
        for (int i = 0; i < score.length; i++) {
            if (map.containsKey(score[i])) {
                if (map.get(score[i]) == 0) {
                    result[i] = topper[0];
                } else if (map.get(score[i]) == 1) {
                    result[i] = topper[1];
                } else if (map.get(score[i]) == 2) {
                    result[i] = topper[2];
                } else {
                    int temp = map.get(score[i]) + 1;
                    result[i] = Integer.toString(temp);
                }
            }
        }
        return result;
    }
}