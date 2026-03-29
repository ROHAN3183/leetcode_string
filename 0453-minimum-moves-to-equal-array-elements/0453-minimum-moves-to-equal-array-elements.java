class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int val : nums) {
            min = Math.min(min, val);
        }
        for (int val : nums) {
            count += Math.abs(min - val);
        }
        return count;
    }
}