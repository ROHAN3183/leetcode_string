class Solution {
    public String smallestSubsequence(String s) {
        StringBuilder result=new StringBuilder();
        int n=s.length();
        int []index=new int[26];
        boolean []used=new boolean[26];
        Arrays.fill(used,false);
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            index[ch-'a']=i;
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(used[ch-'a'])continue;
            while(result.length()>0&&result.charAt(result.length()-1)>ch&&index[result.charAt(result.length()-1)-'a']>i){
                used[result.charAt(result.length()-1)-'a']=false;
                result.deleteCharAt(result.length()-1);
            }
            result.append(ch);
            used[ch-'a']=true;
        }
        return result.toString();
    }
}