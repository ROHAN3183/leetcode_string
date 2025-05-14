Logic of the code:
1) Maintain a hashMap to maintain the frequency.
2) chech that rev of the string in map do list or not .
3) After that check that orginal and reverse are not same  then calculate the size of the string.
4) if same then add to the size in such a way that it will "(size+=leftfreq/2)*2" ex -gg gg gg gg gg there 5 pair are there but 
    only 4 pair will make valid pair rest just again put into the hash for futher future use .
5) check for the pair which is having 1 count like "pp" take 1 and then break; 

class Solution {
    public int longestPalindrome(String[] words) {
        int n=words.length;
        HashMap<String,Integer>map=new HashMap<>();
        int size=0;
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
