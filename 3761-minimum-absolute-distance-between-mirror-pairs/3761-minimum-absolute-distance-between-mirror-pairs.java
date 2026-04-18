class Solution {
    HashMap<Integer, List<Integer>> map;
    int min = Integer.MAX_VALUE;

    public int minMirrorPairDistance(int[] nums) {
        map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            isValid(nums, i);
        }
        if (min != Integer.MAX_VALUE) {
            return min;
        }
        return -1;

    }

    void isValid(int[] nums, int i) {
        String str = Integer.toString(nums[i]);
        int j = str.length() - 1;
        while (j >= 0 && str.charAt(j) == '0') {
            j--;
        }
        String s = "";
        for (int k = j; k >= 0; k--) {
            s += str.charAt(k);
        }
        int val = Integer.parseInt(s);
        if (map.containsKey(val)) {
            List<Integer> list = map.get(val);
            int bs = binarySearch(list, i);
            if (bs != Integer.MAX_VALUE) {
                min = Math.min(min, Math.abs(i - bs));
            }
        }
        return;
    }

    int binarySearch(List<Integer> list, int i) {
        int low = 0;
        int high = list.size() - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) > i) {
                ans = list.get(mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}