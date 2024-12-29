class Solution {
    public String removeDuplicates(String s) {
        int n=s.length();
        StringBuilder result= new StringBuilder();
        int i=0;
        while(i<n){
            char ch=s.charAt(i);
                if(result.length()>0&&result.charAt(result.length()-1)==ch){
                result.deleteCharAt(result.length()-1);

            }
            else{
                result.append(ch);
            }
            i++;
        }
        return result.toString();
    }
}