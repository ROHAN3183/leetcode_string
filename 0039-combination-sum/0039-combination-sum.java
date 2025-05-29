class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        sum(candidates,target,0,result,list);
        return result;
        
    }
    void sum(int []candidates,int target,int i,List<List<Integer>>result,List<Integer>list){
        if(target==0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target<0||i>=candidates.length){
            return;
        }

        list.add(candidates[i]);

        sum(candidates,target-candidates[i],i,result,list);//allow to use 

        list.remove(list.size()-1);

        sum(candidates,target,i+1,result,list);// exclude this 


    }
}