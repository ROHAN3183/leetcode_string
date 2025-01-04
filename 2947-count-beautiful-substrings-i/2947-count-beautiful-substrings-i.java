class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n=s.length();
        int i=0;
        int j=0;
        int vowel_count=0;
        int consonant_count=0;
        int result=0;
        while(i<n){
           if(j<n){
             char ch =s.charAt(j);
            if(isVowel(ch)){
                vowel_count++;
            }
            else{
                consonant_count++;
            }
            if(vowel_count==consonant_count && (vowel_count*consonant_count)%k==0){
                result++;
            }
            j++;

           }
            else{
                    vowel_count=0;
                    consonant_count=0;
                    i++;
                    j=i;
            }
        }
        return result;
    }
    boolean isVowel(char ch){
        return "aeiou".indexOf(ch)!=-1;
    }
}