class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder str=new StringBuilder();
        int n2=shifts.length;
        int n1=s.length();
        int prefix[]=new int [n2];
        long sum=0;

        for(int i=n1-1;i>=0;i--){
            sum=sum+shifts[i];
            prefix[i]=(int)sum%26;
        }

        for(int i=0;i<n1;i++){
            char ch=s.charAt(i);
            int value=(int)ch-(int)'a';
            int shiftedValue=(value+prefix[i])%26;
            char newElement=(char)(shiftedValue+(int)'a');
            str.append(newElement);

        }
        return str.toString();

    }
}