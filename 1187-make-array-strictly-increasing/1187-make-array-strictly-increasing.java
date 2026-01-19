class Solution {
    HashMap<String, Integer> map;

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        map = new HashMap<>();
        Arrays.sort(arr2);
        int val = dfs(arr1, arr2, 0, -1);
        return val != Integer.MAX_VALUE ? val : -1;
    }

    int dfs(int[] arr1, int[] arr2, int idx, int prev) {
        if (idx >= arr1.length) {
            return 0;
        }
        String key = idx + "|" + prev + "|";
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int option1 = Integer.MAX_VALUE;
        int option2 = Integer.MAX_VALUE;
        if (prev == -1 || arr1[idx] > prev) {
            option1 = 0 + dfs(arr1, arr2, idx + 1, arr1[idx]);
        }
        int val = binary_Search_UpperBound(arr2, prev);
        if (val != -1) {
            option2 = dfs(arr1, arr2, idx + 1, arr2[val]);
            if (option2 != Integer.MAX_VALUE) {
                option2 = 1 + option2;
            }
        }
        int min = Math.min(option1, option2);
        map.put(key, min);
        return min;
    }

    int binary_Search_UpperBound(int[] arr2, int target) {
        int low = 0;
        int high = arr2.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr2[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}