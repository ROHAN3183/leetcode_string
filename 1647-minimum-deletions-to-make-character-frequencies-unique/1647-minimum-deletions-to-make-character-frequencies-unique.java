class Solution {
    public int minDeletions(String s) {
        int n=s.length();
        int count=0;
        HashMap<Character,Integer>map=new HashMap<>();
        List<Integer>list=new ArrayList<>();
        HashSet<Integer>set=new HashSet<>();

        for(int i=0;i<n;i++){//frequency map
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer>entry:map.entrySet()){//build heap
            int value=entry.getValue();
            list.add(value);
        }
        Integer[]arr= list.toArray(new Integer[0]);

        for(int i=0;i<arr.length;i++){
            while(set.contains(arr[i])){
                arr[i]=arr[i]-1;
                count++;

            }
           if(arr[i]!=0) set.add(arr[i]);
        }



    return count;

    }
}