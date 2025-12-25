class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int result = 0;
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ch, list);
            } else {
                map.get(ch).add(i);
            }
            i++;
        }

        for (String str : words) {
            int prev = -1;
            int j = 0;
            for (char ch : str.toCharArray()) {
                if (!map.containsKey(ch)) {
                    break;
                } else if (BinarySearch(map.get(ch), prev) == Integer.MAX_VALUE) {
                    break;
                }
                prev = BinarySearch(map.get(ch), prev);
                if (j == str.length() - 1) {
                    result++;
                }
                j++;
            }
        }
        return result;
    }

    int BinarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        int idx = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) > target) {
                idx = list.get(mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return idx;
    }
}