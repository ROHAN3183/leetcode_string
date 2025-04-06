logic for code :
focus on the mantaining maximum count of the frequency of the window and size of the window .
difference between both should be less than k.

class Solution {
    public int characterReplacement(String s, int k) {
        int [] freq =new int [26];
        int n=s.length();
        int max_freq=0;
        int max_length=0;
        int i=0;
        int j=0;
        while(j<n){
            char ch =s.charAt(j);
            freq[ch-'A']++;
            max_freq=Math.max(max_freq,freq[ch-'A']);
            if((j-i+1)-max_freq>k){
                freq[s.charAt(i)-'A']--;
                i++;
            }
            max_length=Math.max(max_length,j-i+1);
            j++;
        }
        return max_length;
    }
}
