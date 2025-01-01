class Solution {
    public boolean isSubsequence(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        int i=0;
        int j=0;
        int count=0;
        if(n2<1){
            return true;
        }
        while(i<n2&&j<n1){
            char x=t.charAt(i);
            char y=s.charAt(j);
            if(x==y){
                count++;
                j++;

            }
            if(count==n1){
                return true;
            }
            i++;
        }
        return false;
    }
}