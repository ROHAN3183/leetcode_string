class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
        }
        return solve(stones,map,0,0);
    }
    boolean solve(int [] stones ,Map<Integer,Integer>map ,int current_index ,int last_jump){
        if(current_index==stones.length-1){
            return true;
        }
        boolean result=false;
        for(int next_jump=last_jump-1;next_jump<=last_jump+1;next_jump++){
            if(next_jump > 0 ){
                int next_position=stones[current_index] + next_jump;
                if(map.containsKey(next_position)){
                    result=result||solve(stones,map,map.get(next_position) ,next_jump);

                }
            }
        }
        return result;
    }
}