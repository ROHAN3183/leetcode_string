# BRUTE FORCE
    class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n=words.length;
        int count=0;
        for(int i=0;i<n;i++){
            String s=words[i];
            for(int j=i+1;j<n;j++){
                String str=words[j];
                if(isValid(s,str)){
                    count++;
                }
            }
        }
        return count;
    }
    boolean isValid(String s,String str){ //Better result use startsWith() AND endsWith() 
        int n1=s.length();
        int n2=str.length();
        if(n1>n2){
            return false;
        }
        String prefix=str.substring(0,n1);
        String suffix=str.substring(n2-n1);
        if(s.equals(prefix) && s.equals(suffix)){
            return true;
        }
        return false;
    }
}
