class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int i=0;
        int j=0;
        int max_length=-1;
        int count=0;
        while(j<n){
            char ch_left=s.charAt(i);
            char ch_right=s.charAt(j);
            if(ch_left!=ch_right){
                count++;
            }
            if(count>k){
                count=0;
                i=j;
            }


            max_length=Math.max(max_length,j-i+1);
            j++;
        }
        return max_length;
    }
}