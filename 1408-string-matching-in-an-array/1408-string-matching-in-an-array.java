class Solution {
    public List<String> stringMatching(String[] words) {
        int n=words.length;
        ArrayList<String>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String x=words[i];
            for(int j=0;j<n;j++){
                String str=words[j];
                if(i!=j){
                    if(isValid(str,x)){
                        if(!list.contains(str)){
                            list.add(str);
                        }
                    }
                }
            }
        }
        return list;
    }
    boolean isValid(String str,String x){
        return (x).indexOf(str)!=-1;
    }
}