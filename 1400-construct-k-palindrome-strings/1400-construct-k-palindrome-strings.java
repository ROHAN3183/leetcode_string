#Approach 
class Solution {
    public boolean canConstruct(String s, int k) {//if count of character present is odd it means increase the count .
        int n=s.length();
        int [] frequency=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            frequency[ch-'a']++;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(frequency[i]%2!=0){
                count++;
            }
        }
        if(count>k){
            return false;
        }
        return true;
    }
}
