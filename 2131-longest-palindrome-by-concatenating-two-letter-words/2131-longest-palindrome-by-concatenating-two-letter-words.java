class Solution {
    public int longestPalindrome(String[] words) {
        int n=words.length;

        StringBuilder leftString=new StringBuilder();
        StringBuilder rightString=new StringBuilder();
        StringBuilder mid=new StringBuilder();
        int [] usedString=new int[n];
        Arrays.fill(usedString,1);
        int size=0;
        boolean flag=true;
        int midCount=0;

       

        for(int i=0;i<n;i++){
            String element=words[i];
            int idx=i;
            if( usedString[i]==1 && reverseFound(words,idx,element,rightString,usedString)){
                leftString.append(element);
            }
        }
        for(int j=0;j<n;j++){
            if(words[j].charAt(0)==words[j].charAt(1)&& flag ==true && usedString[j]==1){
                usedString[j]=0;
                midCount=midCount+2;
                flag=!flag;
            }
        }
        size=leftString.toString().length()+rightString.toString().length()+midCount;
        return size;

    }
    boolean reverseFound(String [] words,int idx,String element,StringBuilder rightString,int []usedString){
        int n=words.length;
        StringBuilder rev=new StringBuilder();
        String result=rev.append(element).reverse().toString();
        for(int i=0;i<n;i++){

            if(i==idx){
                continue;
            }
            if(result.equals(words[i]) && usedString[i]!=0){
                usedString[i]=0;
                usedString[idx]=0;
                rightString.insert(0,words[i]);
                return true;
            }
        }
        return false;
    }
}