class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n=s.length();
        int i=0;
        int j=0;
        int result=n*(n+1)/2;
        if(k==1){
            return n*(n+1)/2;
        }
        HashMap<Character,Integer>map=new HashMap<>();

        while(j<n){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.get(ch)>=k){
                //result=result+n-j;
                char left=s.charAt(i);
                map.put(left,map.get(left)-1);
                if(map.get(left)==0){
                    map.remove(left);
                }
                i++;
            }
            result=result-(j-i+1);
            j++;
        }
        return result;
        
    }
}