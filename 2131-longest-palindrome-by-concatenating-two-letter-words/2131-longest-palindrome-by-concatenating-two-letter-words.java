class Solution {
    public int longestPalindrome(String[] words) {
        int n=words.length;
        HashMap<String,Integer>map=new HashMap<>();
        int size=0;
        boolean flag=true;
        for(int i=0;i<n;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        for(Map.Entry<String,Integer>entry:map.entrySet()){

            String left=entry.getKey();
            String right=entry.getKey();
            String rightRev = new StringBuilder(left).reverse().toString();
            

            if(map.containsKey(rightRev) && map.get(rightRev)!=0 && map.get(left)!=0){
                int leftSize=map.get(left);
                int rightSize=map.get(rightRev);

                if(!left.equals(rightRev)){
                    size=size+Math.min(leftSize,rightSize)*2;
                    map.put(left,0);
                    map.put(rightRev,0);
                }
                else{
                    size=size+(map.get(left)/2)*2;
                    map.put(left,leftSize%2);
                }

            }
            
        }
        for(Map.Entry<String,Integer>entry:map.entrySet()){
            String midString =entry.getKey();
            int midValue=entry.getValue();
            if(midString.charAt(0)==midString.charAt(1) && midValue >0){
                size=size+1;
                break;
            }
        }
        return size*2;

    }
}