class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=tasks.length;
        int ans=0;
        for(int i=0;i<n;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }

        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int freq=entry.getValue();
            if(freq==1){
                return -1;
            }
            if(freq%3==0){
                ans=ans+freq/3;
            }
            else{
                ans=ans+freq/3+1;
            }

        }
        return ans;
    }
}