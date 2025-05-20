class Solution {
    public int minDeletions(String s) {
        int n=s.length();
        HashMap<Character,Integer>map=new HashMap<>();

        for(int i=0;i<n;i++){//frequency map
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Integer>list=new ArrayList<>();

        for(Map.Entry<Character,Integer>entry:map.entrySet()){//build array
            int value=entry.getValue();
            list.add(value);

        }
        Integer[] arr=list.toArray(new Integer[0]);
        Arrays.sort(arr,Collections.reverseOrder());//sorting

        int i=0;
        int j=i+1;
        int count=0;
        int arrSize=arr.length;

        while(j < arrSize && i<j){ // logic

            if( j < arrSize && arr[i]!=arr[j]){
                i++;
                j++;
            }
            else if(arr[i]==arr[j]){
                arr[j]=arr[j]-1;
                count++;
                Arrays.sort(arr,Collections.reverseOrder());
                if(arr[i]==0 ||arr[j]==0){
                    break;
                }
            }

        }
    return count;
    }
}