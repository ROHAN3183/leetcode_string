class Solution {
    public int[][] merge(int[][] arr) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int[] interval = new int[] { arr[0][0], arr[0][1] };
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= interval[1] && interval[0] <= arr[i][1]) {
                int min_start = Math.min(arr[i][0], interval[0]);
                int max_end = Math.max(arr[i][1], interval[1]);
                interval[0] = min_start;
                interval[1] = max_end;

            } else {
                list.add(new int[] { interval[0], interval[1] });
                interval[0] = arr[i][0];
                interval[1] = arr[i][1];

            }
        }
        list.add(new int[] { interval[0], interval[1] });

        return list.toArray(new int[list.size()][]);
    }
}