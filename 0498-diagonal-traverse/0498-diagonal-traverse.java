class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        TreeMap<Integer,List<Integer>>map=new TreeMap<>();
        List<Integer>ans=new ArrayList<>();
       

        int n=mat.length;
        int m=mat[0].length;


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int key=i+j;
                map.putIfAbsent(key,new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }

        
        for(Map.Entry<Integer,List<Integer>>entry:map.entrySet()){
            int key=entry.getKey();
            if((entry.getKey())%2==0){
                Collections.reverse(map.get(key));
            }
        }



        for(Map.Entry<Integer,List<Integer>>entry:map.entrySet()){
            List<Integer>listValue=entry.getValue();
            ans.addAll(listValue);

        }
        int []result=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i]=ans.get(i);
        }
        return result;
        
    }
}