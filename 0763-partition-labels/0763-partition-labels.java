class Solution {
    public List<Integer> partitionLabels(String s) {
        int n=s.length();
        
        int [] start=new int[26];
        int [] end=new int[26];
        Arrays.fill(start,-1);
        Arrays.fill(end,-1);

        HashMap<Character,Integer>map=new HashMap<>();
        ArrayList<Integer>result=new ArrayList<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,i);
                start[(int)ch-'a']=i;
            }
            end[(int)ch-'a']=i;
        }
        int a1=start[0];
        int a2=end[0];
        int i=1;
        while(i<26){
            if(start[i]<0||end[i]<0){
                i++;
                continue;
            }

            if( i<26 && a2>=start[i] && a1<=end[i]){//overlapping
                while(i<26 && a2>=start[i] && a1<=end[i]){
                    a1=Math.min(a1,start[i]);
                    a2=Math.max(a2,end[i]);
                    i++;

                }
                result.add(a2-a1+1);

            }
            else{
                a1=start[i];
                a2=end[i];
                i++;

            }   

        }
        return result;
    }
}