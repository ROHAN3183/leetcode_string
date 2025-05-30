class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        permutation(nums,result,list);
    
        return result;
        
    }
    void permutation(int []nums,List<List<Integer>>result,List<Integer>list){
        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
        }
        for(int i=0;i<nums.length;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                permutation(nums,result,list);
                list.remove(list.size()-1);
            }
        }

    }

}