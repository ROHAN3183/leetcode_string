logic of the code:

just take the array of 26 size to store the frequency of that if any character is found in the fre1 like 'd' where as in fre2 'd' is not there then
return false. otherwise sort it.a and if it found the all the equal then return true else false.
    
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int [] fre2=new int[26];
        int [] fre1=new int[26];
        if(n1!=n2){
            return false;
        }
        for(int i=0;i<n1&&i<n2;i++){
            char ch1=word1.charAt(i);
            char ch2=word2.charAt(i);
            fre1[ch1-'a']=fre1[ch1-'a']+1;
            fre2[ch2-'a']=fre2[ch2-'a']+1;
        }
        for(int i=0;i<26;i++){
            if(fre1[i]>0 &&fre2[i]==0 || fre1[i]==0 &&fre2[i]>0){
                return false;
            }
        }
        Arrays.sort(fre1);
        Arrays.sort(fre2);
        for(int i=0;i<26;i++){
            if(fre1[i]!=fre2[i]){
                return false;
            }
        }
        return true;
    }
}
