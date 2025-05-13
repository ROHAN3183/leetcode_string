class Solution {
    public int maximum69Number (int num) {
        StringBuilder str=new StringBuilder();
        while(num >0){
            str.append(num%10);
            num=num/10;
        }
        str.reverse();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='9'){
                str.setCharAt(i,'9');
                break;
            }
        }
        String result=str.toString();
        int ans=Integer.parseInt(result);
        return ans;
    }
}