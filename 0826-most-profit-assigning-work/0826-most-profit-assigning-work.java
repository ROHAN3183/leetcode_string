class Solution {

    class Pair {
        int difficult;
        int profit;

        Pair(int difficult, int profit) {
            this.difficult = difficult;
            this.profit = profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair>list=new ArrayList<>();
        int ans=0;
        for(int i = 0;i<difficulty.length;i++){
            list.add(new Pair(difficulty[i],profit[i]));
        }
        Collections.sort(list ,(a,b)->(a.difficult-b.difficult));
        Arrays.sort(worker);

        for(int i=0;i<worker.length;i++){
            int value = worker[i];
            int max=0;
            for(int j=0;j<list.size();j++){
               if(list.get(j).difficult>value){
                break;
               }
                max=Math.max(list.get(j).profit,max);
            }
            ans+=max;
        }
        return ans;
    }
}