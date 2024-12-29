class Solution {
    public String reverseWords(String s) {
        StringBuilder str=new StringBuilder();
        String []words=s.split(" ");
        for(String word:words){
            StringBuilder temp =new StringBuilder(word);
            str.append(temp.reverse());
            str.append(" ");
        }
        return str.toString().trim();
    }
}