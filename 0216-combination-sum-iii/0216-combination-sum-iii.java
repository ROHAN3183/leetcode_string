class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        sum(k,n,1,list,result);
        return result;
        
    }
    void sum(int k,int n,int i,List<Integer>list,List<List<Integer>>result){
        if(k==0 && n==0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(n<0 || k<0||i>9){
            return;
        }
        list.add(i);
        sum(k-1,n-i,i+1,list,result);
        list.remove(list.size()-1);
        sum(k,n,i+1,list,result);
    }
}