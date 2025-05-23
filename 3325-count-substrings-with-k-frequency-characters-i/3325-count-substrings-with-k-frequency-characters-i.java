class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n=s.length();
        HashMap<Character,Integer>map=new HashMap<>();
        int i=0;
        int j=0;
        boolean flag=true;
        int result=0;
        if(k==1){
            return n*(n+1)/2;
        }

        while(j<n){
            char ch =s.charAt(j);

           if(map.containsKey(ch) && map.get(ch)!=-1){
             map.put(ch,map.getOrDefault(ch,0)+1);
            }
            else{
                map.put(ch,map.getOrDefault(ch,0)+1);
            }

            if(map.containsKey(ch) && map.get(ch)>=k){
                char firstTime=s.charAt(i);
                while(s.charAt(i)!=(ch)){
                    i++;
                }
                if(flag){
                    result=result+ n-(j-i);
                    flag=!flag;//first count both forword and the back
                }
                else{
                    result+=n-j;
                }
                i=0; // to again find the starting point of the character 
                map.put(ch,-1);//to mark that it has been used.

            }
            j++;

        }
        return result;
        
    }
}