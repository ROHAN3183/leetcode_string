# BRUTE FORCE SOLUTION

class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;

        for(int i=0;i<n;i++){
            StringBuilder str=new StringBuilder();
            for(int j=i;j<n;j++){

                str.append(s.charAt(j));
                char [] temp=str.toString().toCharArray();
                if(reverse(temp)){
                    count++;
                }
                
            }
        }
        return count;
    }
    boolean reverse(char[] temp ){
        int i=0;
        int j=temp.length-1;
        while(i<=j){
            if(temp[i]!=temp[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
