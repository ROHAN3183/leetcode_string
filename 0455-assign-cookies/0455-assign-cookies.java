class Solution {
    public int findContentChildren(int[] g, int[] s) {

        int no_children=g.length;
        int no_cookies= s.length;

        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int i=0;
        int j=0;

        while(i<no_children && j<no_cookies){

            if(g[i]<=s[j]){
                count++;
                i++;
            }

            j++;

        }
        return count;
    }
}