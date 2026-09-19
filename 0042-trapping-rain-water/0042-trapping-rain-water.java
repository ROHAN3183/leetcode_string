class Solution {
    public int trap(int[] height) {
        int l_max = height[0];
        int r_max = height[height.length - 1];
        int[] l_prefix = new int[height.length];
        int[] r_prefix = new int[height.length];
        l_prefix[0] = l_max;
        r_prefix[height.length - 1] = r_max;
        int ans = 0;
        for (int i = 1; i < height.length; i++) {
            l_prefix[i] = Math.max(l_max, height[i]);
            l_max = l_prefix[i];
        }
        for (int i = height.length - 2; i >= 0; i--) {
            r_prefix[i] = Math.max(r_max, height[i]);
            r_max = r_prefix[i];
        }
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(l_prefix[i], r_prefix[i]) - height[i];
        }
        return ans;
    }
}