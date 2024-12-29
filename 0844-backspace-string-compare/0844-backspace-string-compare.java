class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder result1=new StringBuilder();
        StringBuilder result2=new StringBuilder();
        int n1=s.length();
        int n2=t.length();
        for(int i=0;i<n1;i++){
            char ch=s.charAt(i);
            if(ch=='#'){
                if(result1.length()>0){
                    result1.deleteCharAt(result1.length() - 1);
                }
            }
            else{
              result1.append(ch);
            }
        }
        for(int i=0;i<n2;i++){
            char ch=s.charAt(i);
            if(ch=='#'){
                if(result2.length()>0){
                    result2.deleteCharAt(result2.length() - 1);
                }
            }
            else{
              result2.append(ch);
            }
        }
        if(result1.toString().equals(result2.toString())){
            return true;
        }
        return false;
    }
}