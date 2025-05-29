class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer>list=new ArrayList<>();
        List<List<Integer>>result=new ArrayList<>();
        SubsetFinding(nums,0,result,list);
        return result;
        
    }
    void SubsetFinding(int []nums,int i,List<List<Integer>>result,List<Integer>list){
        if(i==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        SubsetFinding(nums,i+1,result,list);
        list.remove(list.size()-1);
         SubsetFinding(nums,i+1,result,list);
    }
}