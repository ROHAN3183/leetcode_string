class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {

        int[] result = new int[queries.length];
        int[] prefix = new int[nums.length];
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }

        for (int i = 0; i < queries.length; i++) {

            int left = 0;
            int right = prefix.length - 1;
            boolean found = false;
            int tempAns = 0;
            int target = queries[i];

            while (left <= right) {

                int mid = left + (right - left) / 2;
                if (prefix[mid] == target) {
                    result[i] = mid + 1;
                    found = true;
                    break;
                } else if (prefix[mid] < target) {
                    tempAns = mid + 1;
                    left = mid + 1;
                } else {
                    right = mid - 1;

                }

            }

            if (!found) {
                result[i] = tempAns;
            }

        }

        return result;

    }
}