class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=queries.length;
        int [] ans=new int [n];
        for(int i=0;i<n;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            int count=0;
            for(int j=start;j<=end;j++){
                char first=words[j].charAt(0);
                char last=words[j].charAt(words[j].length()-1);
                if(isVowel(first)&&isVowel(last)){
                    count++;
                }
            }
            ans[i]=count;
        }
        return ans;
    }
    boolean isVowel(char c){
        return "aeiou".indexOf(c)!=-1;
    }
}