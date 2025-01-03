# logic part!

1. Use an `index` array to store the last occurrence of each character in the string.  
2. Iterate through the string and check if the last occurrence of a character is at least 2 indices ahead.  
3. Use a `HashSet` to collect distinct middle characters between the first and last occurrence.  
4. Avoid duplicate counting using `set_palindrome` to track processed starting characters.  
5. Add the size of the middle-character set to the result and clear the set for the next iteration.  
    
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int result=0;
        Set<Character>set_palindrome=new HashSet<>();
        Set<Character>set=new HashSet<>();
        int [] index=new int[26];
        Arrays.fill(index,-1);
        for(int idx=0;idx<n;idx++){
            index[s.charAt(idx)-'a']=idx;
        }
        int i=0;
        while(i<n){
            char ch=s.charAt(i);
            if(index[ch-'a']>=i+2){
                int count=0;
                int j=index[ch-'a'];
                if(!set_palindrome.contains(s.charAt(i))){
                    for(int start=i+1;start<j;start++){
                    set.add(s.charAt(start));
                }
                count=set.size();
                set.clear();
                }
                result=result+count;
                set_palindrome.add(s.charAt(i));
            }
            i++;
        }
        return result;
    }
}
