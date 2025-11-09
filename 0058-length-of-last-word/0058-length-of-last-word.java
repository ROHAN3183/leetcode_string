class Solution {
    public int lengthOfLastWord(String s) {
        String str=s.trim();
        String [] words=str.split("\\s+");
        String ans=words[words.length-1];
        return ans.length();
    }
}