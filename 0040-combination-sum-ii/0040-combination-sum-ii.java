class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
        if(i>=candidates.length||target<0){
            return;
        }
        list.add(candidates[i]);
        sum(candidates,target-candidates[i],i+1,result,list);
        while(i+1<candidates.length && candidates[i]==candidates[i+1]){
            i++;
        }
        list.remove(list.size()-1);
        sum(candidates,target,i+1,result,list);
    }
}