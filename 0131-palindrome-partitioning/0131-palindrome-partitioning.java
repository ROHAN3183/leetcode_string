class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>result=new ArrayList<>();
        List<String>ans=new ArrayList<>();
        
        combination(result,ans,s,0);
        return result;
    }
    void combination(List<List<String>>result,List<String>ans,String s,int idx){
        if(s.length()==idx){
            result.add(new ArrayList<>(ans));
            return;
        }

        for(int i=idx;i<s.length();i++){
            String palindrome=s.substring(idx,i+1);
            if(isValid(palindrome)){
                ans.add(palindrome);
                combination(result,ans,s,i+1);
                ans.remove(ans.size()-1);
            }
        }
    }
    boolean isValid(String palindrome){
        int i=0;
        int j=palindrome.length()-1;
        while(i<j){
            char left=palindrome.charAt(i);
            char right=palindrome.charAt(j);
            if(left!=right){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}