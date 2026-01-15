class Solution {
    HashMap<Integer, Integer> map;

    public int lenLongestFibSubseq(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, 2 + dfs(arr, i, j));
            }
        }
        if (max <= 2) {
            return 0;
        }
        return max;
    }

    int dfs(int[] arr, int first, int second) {
        int target = arr[first] + arr[second];
        int ans = 0;
        if (map.containsKey(target)) {
            ans = 1 + dfs(arr, second, map.get(target));
        }
        return ans;
    }
}