class Solution {
    public List<Integer> partitionLabels(String s) {
        int n=s.length();
        int []start=new int[26];
        int []end=new int[26];
        Arrays.fill(start,-1);
        Arrays.fill(end,-1);

        HashMap<Character,Integer>map=new HashMap<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch,i);
                start[(int)ch-'a']=i;
            }
            end[(int)ch-'a']=i;
        }

        ArrayList<int[]>list=new ArrayList<>();
        ArrayList<Integer>result=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(start[i]>=0 && end[i]>=0){
                list.add(new int[]{start[i],end[i]});
            } 
        }
        list.sort((a,b)->Integer.compare(a[0],b[0]));
        int currentStart=list.get(0)[0];
        int currentEnd=list.get(0)[1];

        for(int i=1;i<list.size();i++){
            int nextStart=list.get(i)[0];
            int nextEnd=list.get(i)[1];

            if(currentEnd>=nextStart){ //overlapping
                currentStart=Math.min(currentStart,nextStart);
                currentEnd=Math.max(currentEnd,nextEnd);

            }
            else{// non overlapping
                result.add(currentEnd-currentStart+1);
                currentStart=nextStart;
                currentEnd=nextEnd;
            }
        }
        result.add(currentEnd-currentStart+1);
        return result;


    }
}