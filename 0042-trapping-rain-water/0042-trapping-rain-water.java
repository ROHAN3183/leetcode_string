class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int l_max = 0;
        int r_max = 0;
        int ans = 0;
        while (l < r) {
            l_max = Math.max(l_max, height[l]);
            r_max = Math.max(r_max, height[r]);
            if (l_max < r_max) {
                ans += l_max - height[l];
                l++;
            } else {
                ans += r_max - height[r];
                r--;
            }
        }
        return ans;
    }
}