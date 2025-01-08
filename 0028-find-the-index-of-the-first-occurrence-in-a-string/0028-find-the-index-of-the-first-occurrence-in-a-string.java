class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        int idx=0;
        int i=0;
        int j=0;
        if (m == 0) return 0;
        if (n < m) return -1; 
        while(idx<=n-m){
            i=idx;
            j=0;
            while(j<m && haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            if(j==m){
                return idx;
            }
            idx++;
        }
        return -1;
    }
}